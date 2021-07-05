package d.a.s0.n1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f63748a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f63749b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f63750c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f63751d;

    /* renamed from: e  reason: collision with root package name */
    public final View f63752e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f63753f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f63754g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f63755h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f63756i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63758f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f63759g;

        public a(j jVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63759g = jVar;
            this.f63757e = str;
            this.f63758f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63759g.f(this.f63757e, this.f63758f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f63760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f63761f;

        public b(j jVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63761f = jVar;
            this.f63760e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63761f.e(this.f63760e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f63763f;

        public c(j jVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63763f = jVar;
            this.f63762e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                v.c(this.f63763f.k.getPageContext(), this.f63762e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.n1.p.d f63764e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f63765f;

        public d(j jVar, d.a.s0.n1.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63765f = jVar;
            this.f63764e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f63765f.h(this.f63764e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f63766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f63767f;

        public e(j jVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63767f = jVar;
            this.f63766e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.c.e.p.a.a(this.f63766e.t);
                d.a.c.e.p.l.M(this.f63767f.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    public j(LegoListActivity legoListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {legoListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f63748a = navigationBar;
        this.f63752e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f63749b = (RelativeLayout) this.f63748a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f63748a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f63750c = (TextView) this.f63749b.findViewById(R.id.lego_title);
        this.f63751d = (TbImageView) this.f63749b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f63749b.findViewById(R.id.ll_right);
        this.f63753f = linearLayout;
        this.f63754g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f63755h = (TbImageView) this.f63753f.findViewById(R.id.iv2);
        this.f63756i = (TbImageView) this.f63753f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f63754g);
        this.j.add(this.f63755h);
        this.j.add(this.f63756i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f63748a.setVisibility(8);
        }
    }

    public final void e(List<d.a.s0.n1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f63753f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.j.size(); i2++) {
            this.j.get(i2).setVisibility(0);
            if (list.get(i2).f63898d == 2) {
                SkinManager.setImageResource(this.j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i2).M(list.get(i2).f63896b, 10, false);
            } else {
                this.j.get(i2).M(list.get(i2).f63895a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f63897c)) {
                String str = list.get(i2).f63897c;
                if (list.get(i2).f63898d == 1) {
                    this.j.get(i2).setOnClickListener(new c(this, str));
                } else if (list.get(i2).f63898d == 2) {
                    this.j.get(i2).setOnClickListener(new d(this, list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tbImageView = this.f63751d) == null || this.f63750c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f63750c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f63751d.M(str2, 10, false);
        } else {
            this.f63751d.M(str, 10, false);
        }
    }

    public void g(List<d.a.s0.n1.p.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f63753f.setVisibility(8);
                return;
            }
            e(list);
            this.f63753f.postDelayed(new b(this, list), 1000L);
        }
    }

    public void h(d.a.s0.n1.p.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && dVar.f63898d == 2) {
            String str = dVar.f63901g;
            Uri parse = str == null ? null : Uri.parse(str);
            ShareItem shareItem = new ShareItem();
            shareItem.r = dVar.f63899e;
            shareItem.s = dVar.f63900f;
            shareItem.t = dVar.f63897c;
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new e(this, shareItem));
            this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SkinManager.setViewTextColor(this.f63750c, R.color.CAM_X0105);
            this.f63750c.setVisibility(0);
            this.f63751d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.f63750c.setText(str);
            } else {
                this.f63750c.setText("");
            }
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f63751d.postDelayed(new a(this, str, str2), 1000L);
    }
}
