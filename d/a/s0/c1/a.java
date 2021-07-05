package d.a.s0.c1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.home.CreateBarGuideActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import tbclient.UserBfbInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CreateBarGuideActivity f57896a;

    /* renamed from: b  reason: collision with root package name */
    public View f57897b;

    /* renamed from: c  reason: collision with root package name */
    public View f57898c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f57899d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f57900e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f57901f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57902g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57903h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f57904i;
    public LinearLayout j;
    public TbImageView k;
    public UserBfbInfo l;
    public String m;

    /* renamed from: d.a.s0.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1344a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57905e;

        public View$OnClickListenerC1344a(a aVar) {
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
            this.f57905e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57905e.l != null) {
                    if (this.f57905e.l.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(this.f57905e.f57896a.getActivity(), this.f57905e.m, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f57905e.f57896a.getActivity(), this.f57905e.m, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f57905e.f57896a.getActivity(), this.f57905e.m, true)));
                }
                TiebaStatic.log("c11223");
                this.f57905e.f57896a.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57906a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57906a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f57906a.l == null) {
                return;
            }
            if (this.f57906a.l.res_no.intValue() == 9528) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(this.f57906a.f57896a.getActivity(), this.f57906a.m, true)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.f57906a.f57896a.getActivity(), this.f57906a.m, true)));
            }
        }
    }

    public a(CreateBarGuideActivity createBarGuideActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {createBarGuideActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57896a = createBarGuideActivity;
        View inflate = LayoutInflater.from(createBarGuideActivity.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.f57897b = inflate;
        this.f57896a.setContentView(inflate);
        this.f57898c = this.f57897b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f57897b.findViewById(R.id.view_navigation_bar);
        this.f57901f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57901f.setTitleText(R.string.create_bar);
        this.f57899d = (NoNetworkView) this.f57897b.findViewById(R.id.view_no_network);
        this.f57903h = (TextView) this.f57897b.findViewById(R.id.text_forum_name);
        this.f57902g = (TextView) this.f57897b.findViewById(R.id.text_forum_create);
        this.k = (TbImageView) this.f57897b.findViewById(R.id.status_icon);
        this.f57902g.setOnClickListener(new View$OnClickListenerC1344a(this));
        this.f57904i = (TextView) this.f57897b.findViewById(R.id.text_create_need);
        this.j = (LinearLayout) this.f57897b.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new b(this, 2016458));
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57897b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57898c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.r0.s0.a.a(this.f57896a.getPageContext(), this.f57897b);
            NavigationBar navigationBar = this.f57901f;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f57896a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f57899d;
            if (noNetworkView != null) {
                noNetworkView.c(this.f57896a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.f57900e;
            if (noDataView != null) {
                noDataView.f(this.f57896a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57898c.setVisibility(0);
        }
    }

    public void h(String str, UserBfbInfo userBfbInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, userBfbInfo) == null) {
            this.m = str;
            this.l = userBfbInfo;
            if (this.f57900e == null) {
                int g2 = l.g(this.f57896a.getActivity(), R.dimen.ds100);
                NoDataView a2 = NoDataViewFactory.a(this.f57896a.getPageContext().getPageActivity(), (LinearLayout) this.f57897b.findViewById(R.id.emotion_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, g2), null, null);
                this.f57900e = a2;
                a2.setVisibility(0);
                f();
            }
            TextView textView = this.f57903h;
            textView.setText(this.m + "吧");
            UserBfbInfo userBfbInfo2 = this.l;
            if (userBfbInfo2 != null && userBfbInfo2.res_no.intValue() == 9528) {
                if (this.l.activity_status.intValue() == 0) {
                    this.k.setImageResource(R.drawable.icon_create_attention_n);
                } else {
                    this.k.setImageResource(R.drawable.icon_create_complete_n);
                }
            } else {
                this.f57904i.setVisibility(4);
                this.j.setVisibility(4);
            }
            this.f57904i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }
}
