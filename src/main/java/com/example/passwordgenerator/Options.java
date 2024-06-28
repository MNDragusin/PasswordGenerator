package com.example.passwordgenerator;

import java.util.ArrayList;
import java.util.List;

public class Options{
    public final boolean UseLowerCase;
    public final boolean UseUpperCase;
    public final boolean UseNumbers;
    public final boolean UseSpecialCharacters;

    public final List<String> AvailableCharacters;
    public final int ChunkLength;
    public final int NoOfChunks;


    public Options(boolean useLowerCase, boolean useUppercase, boolean useNumbers, boolean useSpecialCharacters, int chunkLength, int noOfChunks)
    {
        ChunkLength = chunkLength;
        NoOfChunks = noOfChunks;

        UseLowerCase = useLowerCase;
        UseUpperCase = useUppercase;
        UseSpecialCharacters = useSpecialCharacters;
        UseNumbers = useNumbers;

        List<String> data = new ArrayList<>();

        if(useLowerCase)
            data.add(Generator.lowerCase);
        if(useUppercase)
            data.add(Generator.upperCase);
        if(useNumbers)
            data.add(Generator.numbers);
        if(useSpecialCharacters)
            data.add(Generator.specialCharacters);

        AvailableCharacters = data;
    }
}
