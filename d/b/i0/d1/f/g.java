package d.b.i0.d1.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f53681a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f53682b;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar != null) {
                g gVar = g.this;
                gVar.e(gVar.d(gVar.f53681a, aVar.n()));
                return;
            }
            g gVar2 = g.this;
            gVar2.e(gVar2.f53682b.getPageContext().getString(R.string.save_fail));
        }
    }

    public g(String str, BaseActivity baseActivity) {
        this.f53681a = null;
        this.f53681a = str;
        this.f53682b = baseActivity;
    }

    public void c() {
        try {
            if (this.f53681a == null || this.f53681a.length() <= 0) {
                e(this.f53682b.getPageContext().getString(R.string.save_fail));
            }
            d.b.b.e.l.d.h().m(this.f53681a, 10, new a(), this.f53682b.getUniqueId());
        } catch (Exception unused) {
            e(this.f53682b.getPageContext().getString(R.string.save_fail));
        }
    }

    public final String d(String str, byte[] bArr) {
        int saveImageFileByUser = FileHelper.saveImageFileByUser(str, bArr, this.f53682b.getPageContext().getPageActivity());
        if (saveImageFileByUser != -2) {
            if (saveImageFileByUser != 0) {
                return this.f53682b.getPageContext().getString(R.string.save_fail);
            }
            return this.f53682b.getPageContext().getString(R.string.save_image_to_album);
        }
        return FileHelper.getSdErrorString();
    }

    public final void e(String str) {
        this.f53682b.showToast(str);
    }
}
