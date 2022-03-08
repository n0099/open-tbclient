package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
/* loaded from: classes7.dex */
public interface EbmlReaderOutput {
    void binaryElement(int i2, int i3, ExtractorInput extractorInput) throws IOException, InterruptedException;

    void endMasterElement(int i2) throws ParserException;

    void floatElement(int i2, double d2) throws ParserException;

    int getElementType(int i2);

    void integerElement(int i2, long j2) throws ParserException;

    boolean isLevel1Element(int i2);

    void startMasterElement(int i2, long j2, long j3) throws ParserException;

    void stringElement(int i2, String str) throws ParserException;
}
