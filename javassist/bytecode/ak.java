package javassist.bytecode;

import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.contact.RContact;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak {

    /* renamed from: a  reason: collision with root package name */
    private w[][] f2761a;
    private int b;

    public ak() {
        this.f2761a = new w[8];
        this.b = 0;
    }

    public ak(int i) {
        this.f2761a = new w[((i >> 7) & (-8)) + 8];
        this.b = 0;
    }

    public w a(int i) {
        if (i < 0 || this.b <= i) {
            return null;
        }
        return this.f2761a[i >> 7][i & RContact.MM_CONTACTFLAG_ALL];
    }

    public void a(w wVar) {
        int i = this.b >> 7;
        int i2 = this.b & RContact.MM_CONTACTFLAG_ALL;
        int length = this.f2761a.length;
        if (i >= length) {
            w[][] wVarArr = new w[length + 8];
            System.arraycopy(this.f2761a, 0, wVarArr, 0, length);
            this.f2761a = wVarArr;
        }
        if (this.f2761a[i] == null) {
            this.f2761a[i] = new w[DERTags.TAGGED];
        }
        this.f2761a[i][i2] = wVar;
        this.b++;
    }
}
