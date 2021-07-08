package d.a.v0.g;
/* loaded from: classes8.dex */
public interface b {
    boolean available();

    int availableBytes();

    void clearQueues();

    void close();

    void flush();

    int getBytes(byte[] bArr, int i2);

    void initVoiceChanger(int i2, int i3, int i4, int i5);

    boolean putBytes(byte[] bArr, int i2);

    void setVoiceChangeType(int[] iArr);
}
