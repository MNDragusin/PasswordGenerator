package com.example.passwordgenerator;

public class Generator {
    protected static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    protected static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected static final String numbers = "0123456789";
    protected static final String specialCharacters = "!@#$%^&*()_=+\\\\/~?";

    public String GenerateNewPassword(Options options){
        StringBuilder password = new StringBuilder();

        for(int i = 0; i<options.NoOfChunks;++i){
            for(int j = 0; j<options.ChunkLength;++j){
                var index = NextRandom(0,options.AvailableCharacters.size() - 1);
                var stringArray = options.AvailableCharacters.get(index);

                password.append(stringArray.charAt(NextRandom(0, stringArray.length() - 1)));
            }

            if(i != options.NoOfChunks -1){
                password.append("-");
            }
        }


        return password.toString();
    }

    private int NextRandom(int min, int max){
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
}


