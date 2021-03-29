package d.b.i0.p0;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
/* loaded from: classes4.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58765a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58766b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58767c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58768d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58769e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58770f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58771g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f58772h;
    public d.b.i0.c2.k.e.u0 i;
    public Bitmap j;
    public e k;
    public View l;
    public String m;
    public String n;
    public d o;
    public int p;
    public View.OnClickListener q = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap m = z.this.m();
            if (view.getId() == z.this.f58766b.getId()) {
                z.this.p(m);
            } else if (view.getId() == z.this.f58767c.getId()) {
                z.this.u(m, 3);
            } else if (view.getId() == z.this.f58768d.getId()) {
                z.this.u(m, 2);
            } else if (view.getId() == z.this.f58769e.getId()) {
                z.this.u(m, 4);
            } else if (view.getId() == z.this.f58770f.getId()) {
                z.this.u(m, 8);
            } else if (view.getId() == z.this.f58771g.getId()) {
                z.this.u(m, 6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.h0.z0.f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f58774a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f58775b;

        public b(Bitmap bitmap, int i) {
            this.f58774a = bitmap;
            this.f58775b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return z.this.l(this.f58774a, this.f58775b);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.h0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f58777a;

        public c(int i) {
            this.f58777a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(z.this.f58765a.getPageActivity(), this.f58777a, shareItem, false));
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i);
    }

    public z(TbPageContext tbPageContext) {
        this.f58765a = tbPageContext;
    }

    public final boolean k() {
        if (this.f58772h == null) {
            this.f58772h = new PermissionJudgePolicy();
        }
        this.f58772h.clearRequestPermissionList();
        this.f58772h.appendRequestPermission(this.f58765a.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return this.f58772h.startRequestPermission(this.f58765a.getPageActivity());
    }

    public final ShareItem l(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.a0 = false;
        shareItem.Z = false;
        shareItem.V = 1;
        if (i == 6) {
            shareItem.r = this.f58765a.getString(R.string.come_on_look_forum) + "[" + this.n + this.f58765a.getString(R.string.core_bar) + "]@" + this.f58765a.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + d.b.b.e.p.k.getUrlEncode(this.n) + "&fr=frsshare";
        } else {
            shareItem.r = this.f58765a.getString(R.string.app_name);
        }
        shareItem.s = "";
        shareItem.h(bitmap);
        shareItem.f();
        return shareItem;
    }

    public Bitmap m() {
        if (this.j == null) {
            d dVar = this.o;
            if (dVar != null) {
                dVar.a();
            }
            this.l.buildDrawingCache();
            this.j = this.l.getDrawingCache();
            d dVar2 = this.o;
            if (dVar2 != null) {
                dVar2.b();
            }
        }
        return this.j;
    }

    public final int n() {
        int k;
        int g2 = d.b.b.e.p.l.g(this.f58765a.getPageActivity(), R.dimen.tbds44);
        int g3 = d.b.b.e.p.l.g(this.f58765a.getPageActivity(), R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.f58765a.getPageActivity()) == 2) {
            k = d.b.b.e.p.l.i(this.f58765a.getPageActivity());
        } else {
            k = d.b.b.e.p.l.k(this.f58765a.getPageActivity());
        }
        return ((k - (g2 * 2)) - g3) / 6;
    }

    public void o(View view, View view2, d dVar) {
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.frs_private_share_download);
        this.f58766b = textView;
        t(textView, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.f58766b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view.findViewById(R.id.frs_private_share_wechat);
        this.f58767c = textView2;
        t(textView2, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        this.f58767c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view.findViewById(R.id.frs_private_share_moment);
        this.f58768d = textView3;
        t(textView3, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        this.f58768d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view.findViewById(R.id.frs_private_share_qzone);
        this.f58769e = textView4;
        t(textView4, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        this.f58769e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view.findViewById(R.id.frs_private_share_qq);
        this.f58770f = textView5;
        t(textView5, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        this.f58770f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view.findViewById(R.id.frs_private_share_weibo);
        this.f58771g = textView6;
        t(textView6, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        this.f58771g.setOnClickListener(this.q);
        this.l = view2;
        this.o = dVar;
    }

    public final void p(Bitmap bitmap) {
        if (k()) {
            return;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(1);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        if (this.i == null) {
            this.i = new d.b.i0.c2.k.e.u0(this.f58765a);
        }
        this.i.b(this.m, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void q(String str, String str2) {
        this.m = str;
        this.n = str2;
    }

    public void r(int i) {
        this.p = i;
    }

    public void s(e eVar) {
        this.k = eVar;
    }

    public final void t(TextView textView, AbsSvgType absSvgType) {
        if (absSvgType == null) {
            return;
        }
        Drawable drawable = absSvgType.getDrawable();
        int g2 = d.b.b.e.p.l.g(this.f58765a.getPageActivity(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g2, g2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = n();
        textView.setLayoutParams(layoutParams);
    }

    public final void u(Bitmap bitmap, int i) {
        if (bitmap == null || k()) {
            return;
        }
        int i2 = 1;
        if (i == 3) {
            i2 = 2;
        } else if (i == 2) {
            i2 = 3;
        } else if (i == 4) {
            i2 = 4;
        } else if (i == 8) {
            i2 = 5;
        } else if (i == 6) {
            i2 = 6;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(i2);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        if (i == 3) {
            statisticItem.param("obj_type", 2);
        } else if (i == 2) {
            statisticItem.param("obj_type", 3);
        } else if (i == 8) {
            statisticItem.param("obj_type", 4);
        } else if (i == 4) {
            statisticItem.param("obj_type", 5);
        } else if (i == 6) {
            statisticItem.param("obj_type", 6);
        }
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        d.b.h0.z0.h0.b(new b(bitmap, i), new c(i));
    }
}
