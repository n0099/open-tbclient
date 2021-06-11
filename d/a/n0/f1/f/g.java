package d.a.n0.f1.f;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f58060a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f58061b;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar != null) {
                g gVar = g.this;
                gVar.e(gVar.d(gVar.f58060a, aVar.n()));
                return;
            }
            g gVar2 = g.this;
            gVar2.e(gVar2.f58061b.getPageContext().getString(R.string.save_fail));
        }
    }

    public g(String str, BaseActivity baseActivity) {
        this.f58060a = null;
        this.f58060a = str;
        this.f58061b = baseActivity;
    }

    public void c() {
        try {
            if (this.f58060a == null || this.f58060a.length() <= 0) {
                e(this.f58061b.getPageContext().getString(R.string.save_fail));
            }
            d.a.c.e.l.d.h().m(this.f58060a, 10, new a(), this.f58061b.getUniqueId());
        } catch (Exception unused) {
            e(this.f58061b.getPageContext().getString(R.string.save_fail));
        }
    }

    public final String d(String str, byte[] bArr) {
        int saveImageFileByUser = FileHelper.saveImageFileByUser(str, bArr, this.f58061b.getPageContext().getPageActivity());
        if (saveImageFileByUser != -2) {
            if (saveImageFileByUser != 0) {
                return this.f58061b.getPageContext().getString(R.string.save_fail);
            }
            return this.f58061b.getPageContext().getString(R.string.save_image_to_album);
        }
        return FileHelper.getSdErrorString();
    }

    public final void e(String str) {
        this.f58061b.showToast(str);
    }
}
