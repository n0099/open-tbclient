package com.thunder.livesdk.helper;
/* loaded from: classes4.dex */
public class HPMarshaller extends Marshallable {
    public IMshBuffer mMshBuffer;

    public HPMarshaller() {
        super(false);
        this.mMshBuffer = null;
    }

    public byte[] HPmarshall(IMshBuffer iMshBuffer) {
        this.mMshBuffer = iMshBuffer;
        this.mBuffer = this.mMshBuffer.getByteBuffer();
        return marshall();
    }

    public void pushMarshallable(IMshBuffer iMshBuffer) {
        this.mMshBuffer = iMshBuffer;
        this.mBuffer = this.mMshBuffer.getByteBuffer();
        marshall(this.mBuffer);
    }

    public void popMarshallable(IMshBuffer iMshBuffer) {
        this.mMshBuffer = iMshBuffer;
        this.mBuffer = this.mMshBuffer.getByteBuffer();
        unmarshall(this.mBuffer);
    }

    public IMshBuffer getMshBuffer() {
        return this.mMshBuffer;
    }

    @Override // com.thunder.livesdk.helper.Marshallable
    protected void increase_capacity(int i) {
        this.mMshBuffer.increase_capacity(i);
        this.mBuffer = this.mMshBuffer.getByteBuffer();
    }
}
