package d.a.k0.g1.k;

import android.text.TextUtils;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.z0.i0;
import d.a.k0.s2.k;
import d.a.k0.s2.o;
import d.a.k0.s2.x;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f55199f = l.g(TbadkApplication.getInst(), R.dimen.tbds44);

    /* renamed from: g  reason: collision with root package name */
    public static final int f55200g = l.k(TbadkApplication.getInst()) - (f55199f * 2);

    /* renamed from: a  reason: collision with root package name */
    public int f55201a;

    /* renamed from: b  reason: collision with root package name */
    public int f55202b;

    /* renamed from: c  reason: collision with root package name */
    public o f55203c;

    /* renamed from: d  reason: collision with root package name */
    public k f55204d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f55205e;

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        k e2 = x.p().e();
        this.f55204d = e2;
        this.f55203c = e2.b(viewStub, tbPageContext);
    }

    public final d.a.j0.z0.c a(int i2, boolean z, boolean z2, String str, int i3, String str2, String str3, String str4) {
        d.a.j0.z0.c cVar = new d.a.j0.z0.c();
        cVar.j = z;
        if (z) {
            return cVar;
        }
        cVar.f50909c = i2;
        cVar.f50910d = z2 ? this.f55202b : this.f55201a;
        MultiImageView multiImageView = this.f55205e;
        if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f55205e.getCurrentUrlDragImageView().getImageView() != null) {
            float[] resizedSize = this.f55205e.getCurrentUrlDragImageView().getImageView().getResizedSize();
            if (resizedSize.length == 2) {
                float f2 = resizedSize[0];
                float f3 = resizedSize[1];
                cVar.f50911e = f3;
                if (f3 != 0.0f) {
                    cVar.f50912f = f2 / f3;
                }
            }
            cVar.f50914h = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
            ImageUrlData imageUrlData = this.f55205e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
            JSONArray jSONArray = null;
            if (imageUrlData != null) {
                try {
                    if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                        jSONArray = new JSONArray(imageUrlData.richTextArray);
                    }
                } catch (JSONException unused) {
                }
            }
            if (jSONArray != null) {
                cVar.f50914h += f55199f * Math.min(((Integer) i0.i(TbRichTextView.S(TbadkCoreApplication.getInst(), jSONArray, false).toString(), l.g(TbadkApplication.getInst(), R.dimen.tbds42), f55200g).second).intValue(), 3);
            }
            if (imageUrlData != null) {
                cVar.k = imageUrlData.isBlockedPic;
            }
        }
        cVar.f50913g = str;
        cVar.f50915i = i3;
        cVar.l = str2;
        cVar.m = str3;
        return cVar;
    }

    public void b() {
        this.f55204d.onDestroy();
        this.f55203c.onDestroy();
    }

    public void c(MultiImageView multiImageView, boolean z, int i2, boolean z2, String str, int i3, String str2, String str3, String str4) {
        this.f55205e = multiImageView;
        d.a.j0.z0.c a2 = a(i2, z2, z, str, i3, str2, str3, str4);
        d(this.f55204d.a(a2), a2, z);
    }

    public final void d(AdvertAppInfo advertAppInfo, d.a.j0.z0.c cVar, boolean z) {
        this.f55203c.a(advertAppInfo, cVar);
        if (advertAppInfo != null) {
            if (z) {
                this.f55202b = Math.max(this.f55202b, cVar.f50909c);
            } else {
                this.f55201a = Math.max(this.f55201a, cVar.f50909c);
            }
        }
    }
}
