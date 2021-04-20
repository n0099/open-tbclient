package d.b.h0.b1.m;

import android.content.res.TypedArray;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class a {
    public static final float G = l.h(TbadkCoreApplication.getInst());
    public int D;
    public int E;
    public TbImageView.g F;
    public boolean r;
    public boolean s;

    /* renamed from: a  reason: collision with root package name */
    public float f50340a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f50341b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public int f50342c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f50343d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f50344e = 15.0f;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50345f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f50346g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f50347h = -1;
    public int i = -16777216;
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
        this.f50340a = aVar.f50340a;
        this.f50341b = aVar.f50341b;
        this.f50342c = aVar.f50342c;
        this.f50343d = aVar.f50343d;
        this.f50344e = aVar.f50344e;
        this.f50346g = aVar.f50346g;
        this.f50347h = aVar.f50347h;
        this.i = aVar.i;
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
        this.z = aVar.f50343d;
        this.A = aVar.A;
        this.C = aVar.C;
    }

    public void b(TypedArray typedArray) {
        this.f50343d = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_segmentMargin, 0);
        this.f50342c = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_textPadding, 0);
        this.f50340a = typedArray.getFloat(R$styleable.TbRichTextView_tbLineSpacing, 1.12f);
        this.f50344e = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_textSize, (int) this.f50344e);
        this.i = typedArray.getColor(R$styleable.TbRichTextView_textColor, this.i);
        this.j = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_maxImageWidth, this.j);
        this.k = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_maxImageHeight, this.k);
        this.l = typedArray.getResourceId(R$styleable.TbRichTextView_defaultImage, 0);
        this.f50346g = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_faceWidth, this.f50346g);
        this.f50347h = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_faceHeight, this.f50347h);
        this.m = typedArray.getResourceId(R$styleable.TbRichTextView_videoImage, 0);
        this.n = typedArray.getBoolean(R$styleable.TbRichTextView_singleLine, false);
        this.z = this.f50343d;
    }

    public boolean c() {
        return this.C;
    }

    public void d() {
    }

    public int[] e(int i, int i2, int i3, int i4) {
        int[] l = l.l(i, i2, i3, i4);
        if (l == null) {
            return null;
        }
        int[] iArr = {l[0], l[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.s && i3 > i5) {
            float f2 = G;
            if (f2 > 1.0f) {
                float f3 = i5;
                float f4 = i3;
                if (f3 * f2 <= f4) {
                    float f5 = f4 * 0.68f;
                    i3 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                i5 = i3;
            }
        }
        return new int[]{i5, i6};
    }

    public void f(int i) {
        this.v = i;
    }

    public void g(int i) {
        this.l = i;
    }

    public void h(int i) {
        this.B = i;
    }

    public void i(int i, int i2) {
        this.f50346g = i;
        this.f50347h = i2;
    }

    public void j(int i) {
        this.A = i;
    }

    public void k(boolean z) {
        this.s = z;
    }

    public void l(int i) {
        this.y = i;
    }

    public void m(int i) {
        this.z = i;
    }

    public void n(float f2) {
        this.f50340a = f2;
    }

    public void o(float f2, float f3) {
        this.f50340a = f3;
        this.f50341b = f2;
    }

    public void p(int i) {
        this.k = i;
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(int i, int i2) {
        this.t = i;
        this.u = i2;
    }

    public void s(int i) {
        this.f50343d = i;
    }

    public void t() {
        this.q = true;
    }

    public void u(int i) {
        this.w = i;
    }

    public void v(int i) {
        this.f50344e = i;
    }

    public void w(boolean z) {
        this.C = z;
    }

    public void x(int i) {
        this.m = i;
    }

    public void y(int i) {
        this.x = i;
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }
}
