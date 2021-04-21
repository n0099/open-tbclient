package d.b.j0.e1.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f55624a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f55625b;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar != null) {
                g gVar = g.this;
                gVar.e(gVar.d(gVar.f55624a, aVar.n()));
                return;
            }
            g gVar2 = g.this;
            gVar2.e(gVar2.f55625b.getPageContext().getString(R.string.save_fail));
        }
    }

    public g(String str, BaseActivity baseActivity) {
        this.f55624a = null;
        this.f55624a = str;
        this.f55625b = baseActivity;
    }

    public void c() {
        try {
            if (this.f55624a == null || this.f55624a.length() <= 0) {
                e(this.f55625b.getPageContext().getString(R.string.save_fail));
            }
            d.b.c.e.l.d.h().m(this.f55624a, 10, new a(), this.f55625b.getUniqueId());
        } catch (Exception unused) {
            e(this.f55625b.getPageContext().getString(R.string.save_fail));
        }
    }

    public final String d(String str, byte[] bArr) {
        int saveImageFileByUser = FileHelper.saveImageFileByUser(str, bArr, this.f55625b.getPageContext().getPageActivity());
        if (saveImageFileByUser != -2) {
            if (saveImageFileByUser != 0) {
                return this.f55625b.getPageContext().getString(R.string.save_fail);
            }
            return this.f55625b.getPageContext().getString(R.string.save_image_to_album);
        }
        return FileHelper.getSdErrorString();
    }

    public final void e(String str) {
        this.f55625b.showToast(str);
    }
}
