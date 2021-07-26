package d.a.q0.v.j.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.p0.s.s.a;
import d.a.q0.v.j.d.m;
/* loaded from: classes8.dex */
public class j extends d.a.d.k.e.a<m, CardViewHolder<d.a.q0.v.j.h.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public d.a.q0.p3.d n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public TextView s;
    public boolean t;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f65476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f65477f;

        public a(j jVar, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65477f = jVar;
            this.f65476e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65477f.l0(this.f65476e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f65478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f65479b;

        public c(j jVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65479b = jVar;
            this.f65478a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f65479b.o ? this.f65479b.p : "0";
                String str2 = this.f65479b.o ? this.f65479b.q : null;
                String str3 = this.f65479b.o ? this.f65479b.r : null;
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                d.a.d.e.i.a.l().h(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f65478a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), m.f65513f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.t = false;
        this.m = tbPageContext;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.q = str;
        }
    }

    public final void k0(m mVar, d.a.q0.v.j.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, mVar, aVar) == null) || mVar.c() == null) {
            return;
        }
        this.s = aVar.q();
        w0();
        aVar.w(8);
        aVar.x(this.f42341e.getResources().getString(R.string.ala_person_center_publish_live));
        aVar.m(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void l0(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, mVar) == null) || mVar == null || mVar.c() == null) {
            return;
        }
        d.a.p0.s.d0.b.j().t(d.a.p0.s.d0.b.n("live_publish_live_has_showed"), true);
        x0(this.s, null, false);
        p0();
        TiebaStatic.log("c13618");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: m0 */
    public CardViewHolder<d.a.q0.v.j.h.a> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new CardViewHolder<>(new d.a.q0.v.j.h.a(this.m)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: n0 */
    public View X(int i2, View view, ViewGroup viewGroup, m mVar, CardViewHolder<d.a.q0.v.j.h.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, mVar, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            k0(mVar, cardViewHolder.b());
            cardViewHolder.b().k().setOnClickListener(new a(this, mVar));
            return cardViewHolder.b().k();
        }
        return (View) invokeCommon.objValue;
    }

    public final void o0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new c(this, tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public final void p0() {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.m.getPageActivity());
                aVar.setAutoNight(false);
                aVar.setTitle(R.string.prompt);
                aVar.setMessage(this.m.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.setPositiveButton(R.string.know, new b(this));
                aVar.create(this.m).show();
            } else if (ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
                if (this.n == null) {
                    this.n = new d.a.q0.p3.d(this.m);
                }
                if (this.o) {
                    if (this.n.c()) {
                        return;
                    }
                } else if (this.n.d()) {
                    return;
                }
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    d.a.d.e.p.l.L(this.m.getPageActivity(), R.string.plugin_config_not_found);
                } else {
                    o0(this.m);
                }
            }
        }
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.p = str;
        }
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.r = str;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.t) {
            return;
        }
        this.t = true;
        if (!d.a.p0.s.d0.b.j().g(d.a.p0.s.d0.b.n("live_publish_live_has_showed"), false)) {
            d.a.p0.s.d0.b.j().t(d.a.p0.s.d0.b.n("live_publish_live_has_showed"), true);
            x0(this.s, null, true);
            return;
        }
        x0(this.s, null, false);
    }

    public final void x0(TextView textView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048589, this, textView, str, z) == null) || textView == null || this.m == null) {
            return;
        }
        if (z) {
            textView.setText("");
            Drawable drawable = this.m.getResources().getDrawable(R.drawable.ala_person_center_red_tip_drawable);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        textView.setCompoundDrawables(null, null, null, null);
    }
}
