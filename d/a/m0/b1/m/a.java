package d.a.m0.b1.m;

import android.content.res.TypedArray;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class a {
    public static final float G = l.h(TbadkCoreApplication.getInst());
    public int D;
    public int E;
    public TbImageView.g F;
    public boolean r;
    public boolean s;

    /* renamed from: a  reason: collision with root package name */
    public float f49093a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f49094b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public int f49095c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f49096d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f49097e = 15.0f;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49098f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f49099g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f49100h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f49101i = -16777216;
    public int j = 200;
    public int k = 200;
    public int l = 0;
    public int m = 0;
    public boolean n = false;
    public int o = -9989158;
    public ImageView.ScaleType p = ImageView.ScaleType.CENTER_CROP;
    public boolean q = false;
    public int t = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    public int w = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int x = 0;
    public int y = -1;
    public int z = -1;
    public int A = -1;
    public int B = 0;
    public boolean C = false;

    public a() {
    }

    public void a(a aVar) {
        this.f49093a = aVar.f49093a;
        this.f49094b = aVar.f49094b;
        this.f49095c = aVar.f49095c;
        this.f49096d = aVar.f49096d;
        this.f49097e = aVar.f49097e;
        this.f49099g = aVar.f49099g;
        this.f49100h = aVar.f49100h;
        this.f49101i = aVar.f49101i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.r = aVar.r;
        this.o = aVar.o;
        this.q = aVar.q;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = aVar.y;
        this.z = aVar.f49096d;
        this.A = aVar.A;
        this.C = aVar.C;
    }

    public void b(TypedArray typedArray) {
        this.f49096d = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_segmentMargin, 0);
        this.f49095c = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_textPadding, 0);
        this.f49093a = typedArray.getFloat(R$styleable.TbRichTextView_tbLineSpacing, 1.12f);
        this.f49097e = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_textSize, (int) this.f49097e);
        this.f49101i = typedArray.getColor(R$styleable.TbRichTextView_textColor, this.f49101i);
        this.j = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_maxImageWidth, this.j);
        this.k = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_maxImageHeight, this.k);
        this.l = typedArray.getResourceId(R$styleable.TbRichTextView_defaultImage, 0);
        this.f49099g = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_faceWidth, this.f49099g);
        this.f49100h = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_faceHeight, this.f49100h);
        this.m = typedArray.getResourceId(R$styleable.TbRichTextView_videoImage, 0);
        this.n = typedArray.getBoolean(R$styleable.TbRichTextView_singleLine, false);
        this.z = this.f49096d;
    }

    public boolean c() {
        return this.C;
    }

    public void d() {
    }

    public int[] e(int i2, int i3, int i4, int i5) {
        int[] l = l.l(i2, i3, i4, i5);
        if (l == null) {
            return null;
        }
        int[] iArr = {l[0], l[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.s && i4 > i6) {
            float f2 = G;
            if (f2 > 1.0f) {
                float f3 = i6;
                float f4 = i4;
                if (f3 * f2 <= f4) {
                    float f5 = f4 * 0.68f;
                    i4 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                }
                if (iArr[0] > 0) {
                    i7 = (iArr[1] * i4) / iArr[0];
                }
                i6 = i4;
            }
        }
        return new int[]{i6, i7};
    }

    public void f(int i2) {
        this.v = i2;
    }

    public void g(int i2) {
        this.l = i2;
    }

    public void h(int i2) {
        this.B = i2;
    }

    public void i(int i2, int i3) {
        this.f49099g = i2;
        this.f49100h = i3;
    }

    public void j(int i2) {
        this.A = i2;
    }

    public void k(boolean z) {
        this.s = z;
    }

    public void l(int i2) {
        this.y = i2;
    }

    public void m(int i2) {
        this.z = i2;
    }

    public void n(float f2) {
        this.f49093a = f2;
    }

    public void o(float f2, float f3) {
        this.f49093a = f3;
        this.f49094b = f2;
    }

    public void p(int i2) {
        this.k = i2;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(int i2, int i3) {
        this.t = i2;
        this.u = i3;
    }

    public void s(int i2) {
        this.f49096d = i2;
    }

    public void t() {
        this.q = true;
    }

    public void u(int i2) {
        this.w = i2;
    }

    public void v(int i2) {
        this.f49097e = i2;
    }

    public void w(boolean z) {
        this.C = z;
    }

    public void x(int i2) {
        this.m = i2;
    }

    public void y(int i2) {
        this.x = i2;
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }
}
