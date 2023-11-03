package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
/* loaded from: classes10.dex */
public class UnknownDescriptor extends BaseDescriptor {
    public static Logger log = Logger.getLogger(UnknownDescriptor.class.getName());
    public ByteBuffer data;

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        return "UnknownDescriptor{tag=" + this.tag + ", sizeOfInstance=" + this.sizeOfInstance + ", data=" + this.data + '}';
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        this.data = (ByteBuffer) byteBuffer.slice().limit(getSizeOfInstance());
    }
}
