package d.a.j0.e1.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f53474a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f53475b;

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
                gVar.e(gVar.d(gVar.f53474a, aVar.n()));
                return;
            }
            g gVar2 = g.this;
            gVar2.e(gVar2.f53475b.getPageContext().getString(R.string.save_fail));
        }
    }

    public g(String str, BaseActivity baseActivity) {
        this.f53474a = null;
        this.f53474a = str;
        this.f53475b = baseActivity;
    }

    public void c() {
        try {
            if (this.f53474a == null || this.f53474a.length() <= 0) {
                e(this.f53475b.getPageContext().getString(R.string.save_fail));
            }
            d.a.c.e.l.d.h().m(this.f53474a, 10, new a(), this.f53475b.getUniqueId());
        } catch (Exception unused) {
            e(this.f53475b.getPageContext().getString(R.string.save_fail));
        }
    }

    public final String d(String str, byte[] bArr) {
        int saveImageFileByUser = FileHelper.saveImageFileByUser(str, bArr, this.f53475b.getPageContext().getPageActivity());
        if (saveImageFileByUser != -2) {
            if (saveImageFileByUser != 0) {
                return this.f53475b.getPageContext().getString(R.string.save_fail);
            }
            return this.f53475b.getPageContext().getString(R.string.save_image_to_album);
        }
        return FileHelper.getSdErrorString();
    }

    public final void e(String str) {
        this.f53475b.showToast(str);
    }
}
