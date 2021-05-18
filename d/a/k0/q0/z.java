package d.a.k0.q0;

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
    public TbPageContext f59713a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59714b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59715c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59716d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59717e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59718f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59719g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f59720h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.d2.k.e.w0 f59721i;
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
            if (view.getId() == z.this.f59714b.getId()) {
                z.this.p(m);
            } else if (view.getId() == z.this.f59715c.getId()) {
                z.this.u(m, 3);
            } else if (view.getId() == z.this.f59716d.getId()) {
                z.this.u(m, 2);
            } else if (view.getId() == z.this.f59717e.getId()) {
                z.this.u(m, 4);
            } else if (view.getId() == z.this.f59718f.getId()) {
                z.this.u(m, 8);
            } else if (view.getId() == z.this.f59719g.getId()) {
                z.this.u(m, 6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.j0.z0.f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f59723a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f59724b;

        public b(Bitmap bitmap, int i2) {
            this.f59723a = bitmap;
            this.f59724b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return z.this.l(this.f59723a, this.f59724b);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.j0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f59726a;

        public c(int i2) {
            this.f59726a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(z.this.f59713a.getPageActivity(), this.f59726a, shareItem, false));
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2);
    }

    public z(TbPageContext tbPageContext) {
        this.f59713a = tbPageContext;
    }

    public final boolean k() {
        if (this.f59720h == null) {
            this.f59720h = new PermissionJudgePolicy();
        }
        this.f59720h.clearRequestPermissionList();
        this.f59720h.appendRequestPermission(this.f59713a.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return this.f59720h.startRequestPermission(this.f59713a.getPageActivity());
    }

    public final ShareItem l(Bitmap bitmap, int i2) {
        ShareItem shareItem = new ShareItem();
        shareItem.c0 = false;
        shareItem.b0 = false;
        shareItem.W = 1;
        if (i2 == 6) {
            shareItem.r = this.f59713a.getString(R.string.come_on_look_forum) + "[" + this.n + this.f59713a.getString(R.string.core_bar) + "]@" + this.f59713a.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + d.a.c.e.p.k.getUrlEncode(this.n) + "&fr=frsshare";
        } else {
            shareItem.r = this.f59713a.getString(R.string.app_name);
        }
        shareItem.s = "";
        shareItem.i(bitmap);
        shareItem.g();
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
        int g2 = d.a.c.e.p.l.g(this.f59713a.getPageActivity(), R.dimen.tbds44);
        int g3 = d.a.c.e.p.l.g(this.f59713a.getPageActivity(), R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.f59713a.getPageActivity()) == 2) {
            k = d.a.c.e.p.l.i(this.f59713a.getPageActivity());
        } else {
            k = d.a.c.e.p.l.k(this.f59713a.getPageActivity());
        }
        return ((k - (g2 * 2)) - g3) / 6;
    }

    public void o(View view, View view2, d dVar) {
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.frs_private_share_download);
        this.f59714b = textView;
        t(textView, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.f59714b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view.findViewById(R.id.frs_private_share_wechat);
        this.f59715c = textView2;
        t(textView2, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        this.f59715c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view.findViewById(R.id.frs_private_share_moment);
        this.f59716d = textView3;
        t(textView3, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        this.f59716d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view.findViewById(R.id.frs_private_share_qzone);
        this.f59717e = textView4;
        t(textView4, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        this.f59717e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view.findViewById(R.id.frs_private_share_qq);
        this.f59718f = textView5;
        t(textView5, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        this.f59718f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view.findViewById(R.id.frs_private_share_weibo);
        this.f59719g = textView6;
        t(textView6, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        this.f59719g.setOnClickListener(this.q);
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
        if (this.f59721i == null) {
            this.f59721i = new d.a.k0.d2.k.e.w0(this.f59713a);
        }
        this.f59721i.b(this.m, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void q(String str, String str2) {
        this.m = str;
        this.n = str2;
    }

    public void r(int i2) {
        this.p = i2;
    }

    public void s(e eVar) {
        this.k = eVar;
    }

    public final void t(TextView textView, AbsSvgType absSvgType) {
        if (absSvgType == null) {
            return;
        }
        Drawable drawable = absSvgType.getDrawable();
        int g2 = d.a.c.e.p.l.g(this.f59713a.getPageActivity(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g2, g2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = n();
        textView.setLayoutParams(layoutParams);
    }

    public final void u(Bitmap bitmap, int i2) {
        if (bitmap == null || k()) {
            return;
        }
        int i3 = 1;
        if (i2 == 3) {
            i3 = 2;
        } else if (i2 == 2) {
            i3 = 3;
        } else if (i2 == 4) {
            i3 = 4;
        } else if (i2 == 8) {
            i3 = 5;
        } else if (i2 == 6) {
            i3 = 6;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(i3);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        if (i2 == 3) {
            statisticItem.param("obj_type", 2);
        } else if (i2 == 2) {
            statisticItem.param("obj_type", 3);
        } else if (i2 == 8) {
            statisticItem.param("obj_type", 4);
        } else if (i2 == 4) {
            statisticItem.param("obj_type", 5);
        } else if (i2 == 6) {
            statisticItem.param("obj_type", 6);
        }
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        d.a.j0.z0.h0.b(new b(bitmap, i2), new c(i2));
    }
}
