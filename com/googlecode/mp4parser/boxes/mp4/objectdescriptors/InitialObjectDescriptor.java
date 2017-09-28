package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class InitialObjectDescriptor extends ObjectDescriptorBase {
    int audioProfileLevelIndication;
    int graphicsProfileLevelIndication;
    int includeInlineProfileLevelFlag;
    int oDProfileLevelIndication;
    private int objectDescriptorId;
    int sceneProfileLevelIndication;
    int urlFlag;
    int urlLength;
    String urlString;
    int visualProfileLevelIndication;
    List<ESDescriptor> esDescriptors = new ArrayList();
    List<ExtensionDescriptor> extensionDescriptors = new ArrayList();
    List<BaseDescriptor> unknownDescriptors = new ArrayList();

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int i;
        int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
        this.objectDescriptorId = (65472 & readUInt16) >> 6;
        this.urlFlag = (readUInt16 & 63) >> 5;
        this.includeInlineProfileLevelFlag = (readUInt16 & 31) >> 4;
        int size = getSize() - 2;
        if (this.urlFlag == 1) {
            this.urlLength = IsoTypeReader.readUInt8(byteBuffer);
            this.urlString = IsoTypeReader.readString(byteBuffer, this.urlLength);
            i = size - (this.urlLength + 1);
        } else {
            this.oDProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.sceneProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.audioProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.visualProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.graphicsProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            int i2 = size - 5;
            if (i2 > 2) {
                BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                i2 -= createFrom.getSize();
                if (createFrom instanceof ESDescriptor) {
                    this.esDescriptors.add((ESDescriptor) createFrom);
                    i = i2;
                } else {
                    this.unknownDescriptors.add(createFrom);
                }
            }
            i = i2;
        }
        if (i > 2) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("InitialObjectDescriptor");
        sb.append("{objectDescriptorId=").append(this.objectDescriptorId);
        sb.append(", urlFlag=").append(this.urlFlag);
        sb.append(", includeInlineProfileLevelFlag=").append(this.includeInlineProfileLevelFlag);
        sb.append(", urlLength=").append(this.urlLength);
        sb.append(", urlString='").append(this.urlString).append('\'');
        sb.append(", oDProfileLevelIndication=").append(this.oDProfileLevelIndication);
        sb.append(", sceneProfileLevelIndication=").append(this.sceneProfileLevelIndication);
        sb.append(", audioProfileLevelIndication=").append(this.audioProfileLevelIndication);
        sb.append(", visualProfileLevelIndication=").append(this.visualProfileLevelIndication);
        sb.append(", graphicsProfileLevelIndication=").append(this.graphicsProfileLevelIndication);
        sb.append(", esDescriptors=").append(this.esDescriptors);
        sb.append(", extensionDescriptors=").append(this.extensionDescriptors);
        sb.append(", unknownDescriptors=").append(this.unknownDescriptors);
        sb.append('}');
        return sb.toString();
    }
}
