package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class InitialObjectDescriptor extends ObjectDescriptorBase {
    public int audioProfileLevelIndication;
    public int graphicsProfileLevelIndication;
    public int includeInlineProfileLevelFlag;
    public int oDProfileLevelIndication;
    public int objectDescriptorId;
    public int sceneProfileLevelIndication;
    public int urlFlag;
    public int urlLength;
    public String urlString;
    public int visualProfileLevelIndication;
    public List<ESDescriptor> esDescriptors = new ArrayList();
    public List<ExtensionDescriptor> extensionDescriptors = new ArrayList();
    public List<BaseDescriptor> unknownDescriptors = new ArrayList();

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int i2;
        int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
        this.objectDescriptorId = (65472 & readUInt16) >> 6;
        this.urlFlag = (readUInt16 & 63) >> 5;
        this.includeInlineProfileLevelFlag = (readUInt16 & 31) >> 4;
        int size = getSize() - 2;
        if (this.urlFlag == 1) {
            int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            this.urlLength = readUInt8;
            this.urlString = IsoTypeReader.readString(byteBuffer, readUInt8);
            i2 = size - (this.urlLength + 1);
        } else {
            this.oDProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.sceneProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.audioProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.visualProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.graphicsProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            i2 = size - 5;
            if (i2 > 2) {
                BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                i2 -= createFrom.getSize();
                if (createFrom instanceof ESDescriptor) {
                    this.esDescriptors.add((ESDescriptor) createFrom);
                } else {
                    this.unknownDescriptors.add(createFrom);
                }
            }
        }
        if (i2 > 2) {
            BaseDescriptor createFrom2 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
            if (createFrom2 instanceof ExtensionDescriptor) {
                this.extensionDescriptors.add((ExtensionDescriptor) createFrom2);
            } else {
                this.unknownDescriptors.add(createFrom2);
            }
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        return "InitialObjectDescriptor{objectDescriptorId=" + this.objectDescriptorId + ", urlFlag=" + this.urlFlag + ", includeInlineProfileLevelFlag=" + this.includeInlineProfileLevelFlag + ", urlLength=" + this.urlLength + ", urlString='" + this.urlString + "', oDProfileLevelIndication=" + this.oDProfileLevelIndication + ", sceneProfileLevelIndication=" + this.sceneProfileLevelIndication + ", audioProfileLevelIndication=" + this.audioProfileLevelIndication + ", visualProfileLevelIndication=" + this.visualProfileLevelIndication + ", graphicsProfileLevelIndication=" + this.graphicsProfileLevelIndication + ", esDescriptors=" + this.esDescriptors + ", extensionDescriptors=" + this.extensionDescriptors + ", unknownDescriptors=" + this.unknownDescriptors + '}';
    }
}
