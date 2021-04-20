package d.b.i0.e1.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f55203a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f55204b;

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
                gVar.e(gVar.d(gVar.f55203a, aVar.n()));
                return;
            }
            g gVar2 = g.this;
            gVar2.e(gVar2.f55204b.getPageContext().getString(R.string.save_fail));
        }
    }

    public g(String str, BaseActivity baseActivity) {
        this.f55203a = null;
        this.f55203a = str;
        this.f55204b = baseActivity;
    }

    public void c() {
        try {
            if (this.f55203a == null || this.f55203a.length() <= 0) {
                e(this.f55204b.getPageContext().getString(R.string.save_fail));
            }
            d.b.c.e.l.d.h().m(this.f55203a, 10, new a(), this.f55204b.getUniqueId());
        } catch (Exception unused) {
            e(this.f55204b.getPageContext().getString(R.string.save_fail));
        }
    }

    public final String d(String str, byte[] bArr) {
        int saveImageFileByUser = FileHelper.saveImageFileByUser(str, bArr, this.f55204b.getPageContext().getPageActivity());
        if (saveImageFileByUser != -2) {
            if (saveImageFileByUser != 0) {
                return this.f55204b.getPageContext().getString(R.string.save_fail);
            }
            return this.f55204b.getPageContext().getString(R.string.save_image_to_album);
        }
        return FileHelper.getSdErrorString();
    }

    public final void e(String str) {
        this.f55204b.showToast(str);
    }
}
