package d.b.j0.q0;

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
    public TbPageContext f60854a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60855b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60856c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60857d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60858e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60859f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60860g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f60861h;
    public d.b.j0.d2.k.e.w0 i;
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
            if (view.getId() == z.this.f60855b.getId()) {
                z.this.p(m);
            } else if (view.getId() == z.this.f60856c.getId()) {
                z.this.u(m, 3);
            } else if (view.getId() == z.this.f60857d.getId()) {
                z.this.u(m, 2);
            } else if (view.getId() == z.this.f60858e.getId()) {
                z.this.u(m, 4);
            } else if (view.getId() == z.this.f60859f.getId()) {
                z.this.u(m, 8);
            } else if (view.getId() == z.this.f60860g.getId()) {
                z.this.u(m, 6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.i0.z0.f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f60863a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60864b;

        public b(Bitmap bitmap, int i) {
            this.f60863a = bitmap;
            this.f60864b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return z.this.l(this.f60863a, this.f60864b);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.i0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f60866a;

        public c(int i) {
            this.f60866a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(z.this.f60854a.getPageActivity(), this.f60866a, shareItem, false));
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
        this.f60854a = tbPageContext;
    }

    public final boolean k() {
        if (this.f60861h == null) {
            this.f60861h = new PermissionJudgePolicy();
        }
        this.f60861h.clearRequestPermissionList();
        this.f60861h.appendRequestPermission(this.f60854a.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return this.f60861h.startRequestPermission(this.f60854a.getPageActivity());
    }

    public final ShareItem l(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.a0 = false;
        shareItem.Z = false;
        shareItem.V = 1;
        if (i == 6) {
            shareItem.r = this.f60854a.getString(R.string.come_on_look_forum) + "[" + this.n + this.f60854a.getString(R.string.core_bar) + "]@" + this.f60854a.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + d.b.c.e.p.k.getUrlEncode(this.n) + "&fr=frsshare";
        } else {
            shareItem.r = this.f60854a.getString(R.string.app_name);
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
        int g2 = d.b.c.e.p.l.g(this.f60854a.getPageActivity(), R.dimen.tbds44);
        int g3 = d.b.c.e.p.l.g(this.f60854a.getPageActivity(), R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.f60854a.getPageActivity()) == 2) {
            k = d.b.c.e.p.l.i(this.f60854a.getPageActivity());
        } else {
            k = d.b.c.e.p.l.k(this.f60854a.getPageActivity());
        }
        return ((k - (g2 * 2)) - g3) / 6;
    }

    public void o(View view, View view2, d dVar) {
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.frs_private_share_download);
        this.f60855b = textView;
        t(textView, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.f60855b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view.findViewById(R.id.frs_private_share_wechat);
        this.f60856c = textView2;
        t(textView2, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        this.f60856c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view.findViewById(R.id.frs_private_share_moment);
        this.f60857d = textView3;
        t(textView3, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        this.f60857d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view.findViewById(R.id.frs_private_share_qzone);
        this.f60858e = textView4;
        t(textView4, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        this.f60858e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view.findViewById(R.id.frs_private_share_qq);
        this.f60859f = textView5;
        t(textView5, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        this.f60859f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view.findViewById(R.id.frs_private_share_weibo);
        this.f60860g = textView6;
        t(textView6, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        this.f60860g.setOnClickListener(this.q);
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
            this.i = new d.b.j0.d2.k.e.w0(this.f60854a);
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
        int g2 = d.b.c.e.p.l.g(this.f60854a.getPageActivity(), R.dimen.tbds88);
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
        d.b.i0.z0.h0.b(new b(bitmap, i), new c(i));
    }
}
