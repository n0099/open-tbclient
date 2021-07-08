package d.a.p0.n3.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f60942a;

    /* renamed from: b  reason: collision with root package name */
    public View f60943b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f60944c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f60945d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60946e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60947f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60948g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60949h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.c.e.l.c<d.a.c.k.d.a> f60950i;

    /* loaded from: classes8.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60951a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60951a = iVar;
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            aVar.h(this.f60951a.f60944c);
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60950i = new a(this);
        this.f60942a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f60943b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f60942a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60943b : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f60944c = (BdExpandImageView) this.f60943b.findViewById(R.id.expand_image);
            this.f60945d = (TbImageView) this.f60943b.findViewById(R.id.user_head);
            TbImageView tbImageView = (TbImageView) this.f60943b.findViewById(R.id.vip_icon);
            this.f60946e = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f60947f = (TextView) this.f60943b.findViewById(R.id.user_name);
            this.f60948g = (ImageView) this.f60943b.findViewById(R.id.user_sex);
            this.f60949h = (TextView) this.f60943b.findViewById(R.id.user_bar_age_num);
            this.f60945d.setDefaultResource(R.drawable.icon_default_avatar100);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f60942a.getPageContext() == null) {
            return;
        }
        d.a.o0.s0.a.a(this.f60942a.getPageContext(), this.f60943b);
    }

    public void e(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        d.a.c.e.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.f60950i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f60949h.setText("0");
        } else {
            this.f60949h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f60949h, R.color.CAM_X0308, 1);
            this.f60947f.setText(R.string.default_user_name);
            this.f60948g.setImageResource(R.drawable.icon_pop_boy);
            this.f60946e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f60945d.M(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f60946e.setVisibility(8);
        } else {
            this.f60946e.M(memberIconUrl, 10, false);
            this.f60946e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f60947f.setTextColor(this.f60942a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f60947f.setTextColor(this.f60942a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f60947f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f60948g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f60948g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f60948g.setVisibility(8);
        }
    }
}
