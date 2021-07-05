package d.a.s0.v.j.g.c.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.l.d;
import d.a.s0.v.j.g.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f68152a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f68153b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f68154c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.v.j.g.c.b f68155d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f68156e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f68157f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f68158g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f68159h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f68160i;
    public ImageView j;
    public TextView k;
    public LinearLayout l;
    public AlaNetRefreshView m;
    public RelativeLayout n;
    public TextView o;
    public View p;
    public c q;
    public List<AlaLiveMarkData> r;
    public b.d s;

    /* renamed from: d.a.s0.v.j.g.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1826a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68161a;

        public C1826a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68161a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((C1826a) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    return;
                }
                this.f68161a.f68159h.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f68161a.f68159h.setImageBitmap(BitmapHelper.fastblur(aVar.p(), 15, 0.75f));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68162a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68162a = aVar;
        }

        @Override // d.a.s0.v.j.g.c.b.d
        public void a(d.a.s0.v.j.g.c.c.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || this.f68162a.q == null) {
                return;
            }
            this.f68162a.q.a(bVar);
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(d.a.s0.v.j.g.c.c.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new ArrayList();
        this.s = new b(this);
        this.f68153b = tbPageContext;
        this.q = cVar;
        e();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68152a : (View) invokeV.objValue;
    }

    public void d() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alaNetRefreshView = this.m) == null) {
            return;
        }
        alaNetRefreshView.dettachView(this.n);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f68153b.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
            this.f68152a = inflate;
            inflate.setPadding(0, (int) this.f68153b.getResources().getDimension(R.dimen.ds80), 0, 0);
            this.f68156e = (HeadImageView) this.f68152a.findViewById(R.id.ala_person_center_privilege_header_iv);
            this.f68157f = (TextView) this.f68152a.findViewById(R.id.ala_person_center_privilege_header_name_tv);
            this.f68158g = (TextView) this.f68152a.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
            this.f68159h = (TbImageView) this.f68152a.findViewById(R.id.ala_person_center_privilege_header_container_bg);
            this.n = (RelativeLayout) this.f68152a.findViewById(R.id.ala_person_center_privilege_mark_list_container);
            this.l = (LinearLayout) this.f68152a.findViewById(R.id.ala_person_center_privilege_header_has_wears);
            this.o = (TextView) this.f68152a.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
            this.j = (ImageView) this.f68152a.findViewById(R.id.empty_image);
            this.k = (TextView) this.f68152a.findViewById(R.id.empty_text);
            this.p = this.f68152a.findViewById(R.id.ala_person_center_privilege_mask);
            this.f68154c = (BdListView) this.f68152a.findViewById(R.id.ala_person_center_privilege_mark_list);
            d.a.s0.v.j.g.c.b bVar = new d.a.s0.v.j.g.c.b(this.f68153b, this.s);
            this.f68155d = bVar;
            this.f68154c.setAdapter((ListAdapter) bVar);
            RelativeLayout relativeLayout = (RelativeLayout) this.f68152a.findViewById(R.id.emptyview);
            this.f68160i = relativeLayout;
            this.f68154c.setEmptyView(relativeLayout);
            this.f68156e.setIsRound(true);
            this.f68156e.setDefaultBgResource(R.color.transparent);
            this.f68156e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f68159h.setDefaultBgResource(R.color.transparent);
            this.f68159h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f68152a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f68157f, R.color.common_color_10310);
            SkinManager.setViewTextColor(this.f68158g, R.color.white_alpha70);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.j.setAlpha(0.4f);
                this.p.setBackgroundColor(this.f68153b.getResources().getColor(R.color.black_alpha60));
                return;
            }
            this.j.setAlpha(1.0f);
            this.p.setBackgroundColor(this.f68153b.getResources().getColor(R.color.black_alpha30));
        }
    }

    public void g(AlaUserInfoData alaUserInfoData, List<d.a.s0.v.j.g.c.c.c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, alaUserInfoData, list) == null) {
            d.a.s0.v.j.g.c.b bVar = this.f68155d;
            if (bVar != null && list != null) {
                bVar.d(list);
            }
            i(alaUserInfoData);
        }
    }

    public void h(int i2, int i3, boolean z, View.OnClickListener onClickListener) {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), onClickListener}) == null) || (tbPageContext = this.f68153b) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new AlaNetRefreshView(tbPageContext.getPageActivity());
        }
        this.m.setImageResource(i2);
        this.m.setNetFailTipText(this.f68153b.getString(i3));
        this.m.onChangeSkinType();
        this.m.setIsShowRefreshButton(z);
        if (z) {
            this.m.setOnRefreshClickListener(onClickListener);
        }
        this.m.attachView(this.n);
    }

    public final void i(AlaUserInfoData alaUserInfoData) {
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, alaUserInfoData) == null) {
            if (alaUserInfoData != null) {
                String str = alaUserInfoData.user_nickname;
                String str2 = alaUserInfoData.user_name;
                if (str == null) {
                    str = str2 != null ? str2 : TbadkCoreApplication.getCurrentAccountNameShow();
                }
                String str3 = alaUserInfoData.portrait;
                if (str3 == null) {
                    str3 = TbadkCoreApplication.getCurrentPortrait();
                }
                if (alaUserInfoData.mark_count == null) {
                    format = String.format(this.f68153b.getString(R.string.ala_achievement_mark_get_text), 0);
                } else {
                    format = String.format(this.f68153b.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
                }
                j(str3, str, format);
                int dimension = (int) this.f68153b.getResources().getDimension(R.dimen.ds32);
                List<AlaLiveMarkData> list = this.r;
                if (list != null && list.size() > 0) {
                    this.r.clear();
                }
                LinearLayout linearLayout = this.l;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                    List<AlaLiveMarkData> list2 = alaUserInfoData.live_mark_info_new;
                    this.r = list2;
                    if (list2 != null) {
                        for (int i2 = 0; i2 < this.r.size(); i2++) {
                            TbImageView tbImageView = new TbImageView(this.f68153b.getPageActivity());
                            tbImageView.setDefaultBgResource(R.color.transparent);
                            tbImageView.M(this.r.get(i2).mark_pic, 21, false);
                            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.f68153b.getResources().getDimension(R.dimen.ds12);
                            this.l.addView(tbImageView);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            j(TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountNameShow(), String.format(this.f68153b.getString(R.string.ala_achievement_mark_get_text), 0));
            List<AlaLiveMarkData> list3 = this.r;
            if (list3 != null && list3.size() > 0) {
                this.r.clear();
            }
            LinearLayout linearLayout2 = this.l;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
        }
    }

    public final void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            if (!StringUtils.isNull(str)) {
                this.f68156e.M(str, 25, false);
                d.h().m(str, 25, new C1826a(this), null);
            } else {
                this.f68156e.M(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
                this.f68159h.M(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            }
            if (!StringUtils.isNull(str2)) {
                this.f68157f.setText(str2);
            } else {
                this.f68157f.setText("");
            }
            if (!StringUtils.isNull(str3)) {
                this.f68158g.setText(str3);
            } else {
                this.f68158g.setText("");
            }
        }
    }
}
