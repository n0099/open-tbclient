package d.a.s0.v1.g;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
/* loaded from: classes9.dex */
public class d extends d.a.c.a.d<MemberPrivilegeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MemberPrivilegeActivity f68439a;

    /* renamed from: b  reason: collision with root package name */
    public View f68440b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f68441c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f68442d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f68443e;

    /* renamed from: f  reason: collision with root package name */
    public c f68444f;

    /* loaded from: classes9.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68445e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68445e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f68445e.f68439a.requestMemberPrivilegeData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberPrivilegeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68439a = memberPrivilegeActivity;
        h();
    }

    public c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68444f : (c) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68440b : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f68439a.setContentView(R.layout.memberprivilege_activity);
            View findViewById = this.f68439a.findViewById(R.id.root);
            this.f68440b = findViewById;
            NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
            this.f68441c = navigationBar;
            navigationBar.setTitleText(R.string.member_center);
            this.f68441c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            NoNetworkView noNetworkView = (NoNetworkView) this.f68440b.findViewById(R.id.nonetworkview);
            this.f68442d = noNetworkView;
            noNetworkView.a(new a(this));
            this.f68443e = (BdListView) this.f68440b.findViewById(R.id.listview);
            c cVar = new c(this.f68439a);
            this.f68444f = cVar;
            this.f68443e.setAdapter((ListAdapter) cVar);
            this.f68443e.setOnItemClickListener(this.f68439a);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f68439a.getLayoutMode().k(i2 == 1);
            this.f68439a.getLayoutMode().j(this.f68440b);
            this.f68441c.onChangeSkinType(this.f68439a.getPageContext(), i2);
            this.f68442d.c(this.f68439a.getPageContext(), i2);
        }
    }
}
