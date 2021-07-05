package d.a.s0.u0;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
/* loaded from: classes9.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67215a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f67216b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67217c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67218d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67219e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f67220f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f67221g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f67222h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.h2.k.e.x0 f67223i;
    public Bitmap j;
    public e k;
    public View l;
    public String m;
    public String n;
    public d o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f67224e;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67224e = yVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Bitmap m = this.f67224e.m();
                if (view.getId() == this.f67224e.f67216b.getId()) {
                    this.f67224e.p(m);
                } else if (view.getId() == this.f67224e.f67217c.getId()) {
                    this.f67224e.u(m, 3);
                } else if (view.getId() == this.f67224e.f67218d.getId()) {
                    this.f67224e.u(m, 2);
                } else if (view.getId() == this.f67224e.f67219e.getId()) {
                    this.f67224e.u(m, 4);
                } else if (view.getId() == this.f67224e.f67220f.getId()) {
                    this.f67224e.u(m, 8);
                } else if (view.getId() == this.f67224e.f67221g.getId()) {
                    this.f67224e.u(m, 6);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.r0.z0.f0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f67225a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f67226b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ y f67227c;

        public b(y yVar, Bitmap bitmap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, bitmap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67227c = yVar;
            this.f67225a = bitmap;
            this.f67226b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67227c.l(this.f67225a, this.f67226b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.r0.z0.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f67228a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f67229b;

        public c(y yVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67229b = yVar;
            this.f67228a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f67229b.f67215a.getPageActivity(), this.f67228a, shareItem, false));
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(int i2);
    }

    public y(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.f67215a = tbPageContext;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f67222h == null) {
                this.f67222h = new PermissionJudgePolicy();
            }
            this.f67222h.clearRequestPermissionList();
            this.f67222h.appendRequestPermission(this.f67215a.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            return this.f67222h.startRequestPermission(this.f67215a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public final ShareItem l(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, i2)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.c0 = false;
            shareItem.b0 = false;
            shareItem.W = 1;
            if (i2 == 6) {
                shareItem.r = this.f67215a.getString(R.string.come_on_look_forum) + PreferencesUtil.LEFT_MOUNT + this.n + this.f67215a.getString(R.string.core_bar) + PreferencesUtil.RIGHT_MOUNT + TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f67215a.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + d.a.c.e.p.k.getUrlEncode(this.n) + "&fr=frsshare";
            } else {
                shareItem.r = this.f67215a.getString(R.string.app_name);
            }
            shareItem.s = "";
            shareItem.i(bitmap);
            shareItem.g();
            return shareItem;
        }
        return (ShareItem) invokeLI.objValue;
    }

    public Bitmap m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return (Bitmap) invokeV.objValue;
    }

    public final int n() {
        InterceptResult invokeV;
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int g2 = d.a.c.e.p.l.g(this.f67215a.getPageActivity(), R.dimen.tbds44);
            int g3 = d.a.c.e.p.l.g(this.f67215a.getPageActivity(), R.dimen.tbds54);
            if (UtilHelper.getRealScreenOrientation(this.f67215a.getPageActivity()) == 2) {
                k = d.a.c.e.p.l.i(this.f67215a.getPageActivity());
            } else {
                k = d.a.c.e.p.l.k(this.f67215a.getPageActivity());
            }
            return ((k - (g2 * 2)) - g3) / 6;
        }
        return invokeV.intValue;
    }

    public void o(View view, View view2, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, view, view2, dVar) == null) || view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.frs_private_share_download);
        this.f67216b = textView;
        t(textView, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.f67216b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view.findViewById(R.id.frs_private_share_wechat);
        this.f67217c = textView2;
        t(textView2, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        this.f67217c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view.findViewById(R.id.frs_private_share_moment);
        this.f67218d = textView3;
        t(textView3, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        this.f67218d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view.findViewById(R.id.frs_private_share_qzone);
        this.f67219e = textView4;
        t(textView4, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        this.f67219e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view.findViewById(R.id.frs_private_share_qq);
        this.f67220f = textView5;
        t(textView5, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        this.f67220f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view.findViewById(R.id.frs_private_share_weibo);
        this.f67221g = textView6;
        t(textView6, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        this.f67221g.setOnClickListener(this.q);
        this.l = view2;
        this.o = dVar;
    }

    public final void p(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) || k()) {
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
        if (this.f67223i == null) {
            this.f67223i = new d.a.s0.h2.k.e.x0(this.f67215a);
        }
        this.f67223i.b(this.m, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.m = str;
            this.n = str2;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.p = i2;
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public final void t(TextView textView, AbsSvgType absSvgType) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, textView, absSvgType) == null) || absSvgType == null || (drawable = absSvgType.getDrawable()) == null) {
            return;
        }
        int g2 = d.a.c.e.p.l.g(this.f67215a.getPageActivity(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g2, g2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = n();
        textView.setLayoutParams(layoutParams);
    }

    public final void u(Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, bitmap, i2) == null) || bitmap == null || k()) {
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
        d.a.r0.z0.i0.b(new b(this, bitmap, i2), new c(this, i2));
    }
}
