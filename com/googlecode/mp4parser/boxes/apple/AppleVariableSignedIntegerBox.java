package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes6.dex */
public abstract class AppleVariableSignedIntegerBox extends AppleDataBox {
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_3 = null;
    int intLength;
    long value;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AppleVariableSignedIntegerBox.java", AppleVariableSignedIntegerBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "int"), 19);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "int", "intLength", "", "void"), 23);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "long"), 27);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "long", "value", "", "void"), 31);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppleVariableSignedIntegerBox(String str) {
        super(str, 15);
        this.intLength = 1;
    }

    public int getIntLength() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.intLength;
    }

    public void setIntLength(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.Sx(i)));
        this.intLength = i;
    }

    public long getValue() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.value;
    }

    public void setValue(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.jy(j)));
        if (j <= 127 && j > -128) {
            this.intLength = 1;
        } else if (j <= 32767 && j > -32768 && this.intLength < 2) {
            this.intLength = 2;
        } else if (j <= 8388607 && j > -8388608 && this.intLength < 3) {
            this.intLength = 3;
        } else {
            this.intLength = 4;
        }
        this.value = j;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        int dataLength = getDataLength();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[dataLength]);
        IsoTypeWriterVariable.write(this.value, wrap, dataLength);
        return wrap.array();
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        this.value = IsoTypeReaderVariable.read(byteBuffer, remaining);
        this.intLength = remaining;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return this.intLength;
    }
}
