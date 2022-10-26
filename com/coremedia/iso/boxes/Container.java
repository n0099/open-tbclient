package com.coremedia.iso.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;
/* loaded from: classes7.dex */
public interface Container {
    List getBoxes();

    List getBoxes(Class cls);

    List getBoxes(Class cls, boolean z);

    ByteBuffer getByteBuffer(long j, long j2) throws IOException;

    void setBoxes(List list);

    void writeContainer(WritableByteChannel writableByteChannel) throws IOException;
}
