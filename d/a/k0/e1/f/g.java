package d.a.k0.e1.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f54181a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f54182b;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar != null) {
                g gVar = g.this;
                gVar.e(gVar.d(gVar.f54181a, aVar.n()));
                return;
            }
            g gVar2 = g.this;
            gVar2.e(gVar2.f54182b.getPageContext().getString(R.string.save_fail));
        }
    }

    public g(String str, BaseActivity baseActivity) {
        this.f54181a = null;
        this.f54181a = str;
        this.f54182b = baseActivity;
    }

    public void c() {
        try {
            if (this.f54181a == null || this.f54181a.length() <= 0) {
                e(this.f54182b.getPageContext().getString(R.string.save_fail));
            }
            d.a.c.e.l.d.h().m(this.f54181a, 10, new a(), this.f54182b.getUniqueId());
        } catch (Exception unused) {
            e(this.f54182b.getPageContext().getString(R.string.save_fail));
        }
    }

    public final String d(String str, byte[] bArr) {
        int saveImageFileByUser = FileHelper.saveImageFileByUser(str, bArr, this.f54182b.getPageContext().getPageActivity());
        if (saveImageFileByUser != -2) {
            if (saveImageFileByUser != 0) {
                return this.f54182b.getPageContext().getString(R.string.save_fail);
            }
            return this.f54182b.getPageContext().getString(R.string.save_image_to_album);
        }
        return FileHelper.getSdErrorString();
    }

    public final void e(String str) {
        this.f54182b.showToast(str);
    }
}
