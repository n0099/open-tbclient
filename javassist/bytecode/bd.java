package javassist.bytecode;

import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class bd {

    /* renamed from: a  reason: collision with root package name */
    private ByteArrayOutputStream f2801a = new ByteArrayOutputStream();

    public byte[] a() {
        return this.f2801a.toByteArray();
    }

    public StackMap a(y yVar) {
        return new StackMap(yVar, this.f2801a.toByteArray());
    }

    public void a(int i, int i2) {
        this.f2801a.write(i);
        if (i == 7 || i == 8) {
            a(i2);
        }
    }

    public void a(int i) {
        this.f2801a.write((i >>> 8) & Util.MASK_8BIT);
        this.f2801a.write(i & Util.MASK_8BIT);
    }
}
