package d.a.s0.j1.a.c;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.s0.j1.a.c.c;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends d.a.c.a.d<InviteFriendListActivity> implements c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InviteFriendListActivity f62145e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f62146f;

    /* renamed from: g  reason: collision with root package name */
    public View f62147g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f62148h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.j1.a.c.c f62149i;
    public NoDataView j;
    public ProgressBar k;
    public View l;
    public InviteFriendCandidateList m;
    public LinearLayout n;
    public Button o;
    public View p;
    public int q;
    public boolean r;
    public TextView s;
    public View t;
    public View u;
    public EditText v;
    public TextView w;
    public TextWatcher x;
    public ImageView y;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62150e;

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
            this.f62150e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(this.f62150e.f62145e.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements InviteFriendCandidateList.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62151a;

        public b(d dVar) {
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
            this.f62151a = dVar;
        }

        @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.b
        public void a(View view, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, obj) == null) || obj == null) {
                return;
            }
            if (obj instanceof TbCheckBox.c) {
                ((TbCheckBox.c) obj).setChecked(false);
            }
            View findViewWithTag = this.f62151a.f62148h.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof d.a.r0.s.f.a) {
                this.f62151a.J((d.a.r0.s.f.a) obj);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62152e;

        public c(d dVar) {
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
            this.f62152e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f62152e.t != null && this.f62152e.t.getVisibility() == 0) {
                    this.f62152e.A();
                    return;
                }
                l.x(this.f62152e.f62145e.getPageContext().getPageActivity(), this.f62152e.v);
                this.f62152e.f62145e.finish();
            }
        }
    }

    /* renamed from: d.a.s0.j1.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1535d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62153e;

        public View$OnClickListenerC1535d(d dVar) {
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
            this.f62153e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62153e.s.setVisibility(8);
                this.f62153e.u.setVisibility(8);
                this.f62153e.t.setVisibility(0);
                this.f62153e.v.requestFocus();
                l.K(this.f62153e.f62145e.getPageContext().getPageActivity(), this.f62153e.v);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62154e;

        public e(d dVar) {
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
            this.f62154e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (charSequence2String = k.charSequence2String(editable, null)) == null) {
                return;
            }
            if (charSequence2String.length() > 0) {
                this.f62154e.w.setVisibility(0);
            } else {
                this.f62154e.w.setVisibility(8);
            }
            this.f62154e.y();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62155e;

        public f(d dVar) {
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
            this.f62155e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62155e.v.getText().clear();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62156e;

        public g(d dVar) {
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
            this.f62156e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f62156e.z();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62157a;

        public h(d dVar) {
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
            this.f62157a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) {
                this.f62157a.z();
                if (obj == null || !(obj instanceof d.a.r0.s.f.a)) {
                    return;
                }
                if (z) {
                    if (this.f62157a.u() <= this.f62157a.m.getItemLength()) {
                        this.f62157a.f62145e.showToast(String.format(this.f62157a.f62145e.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(this.f62157a.q)));
                        tbCheckBox.setChecked(false);
                        ((d.a.r0.s.f.a) obj).setChecked(false);
                        return;
                    }
                    this.f62157a.q((d.a.r0.s.f.a) obj);
                    return;
                }
                this.f62157a.J((d.a.r0.s.f.a) obj);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inviteFriendListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.f62145e = inviteFriendListActivity;
        this.r = z;
        F();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l.x(this.f62145e.getPageContext().getPageActivity(), this.v);
            this.t.setVisibility(8);
            this.s.setVisibility(0);
            this.u.setVisibility(0);
            this.v.getText().clear();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f62147g.findViewById(R.id.view_navigation_bar);
            this.f62146f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            if (this.r) {
                this.s = this.f62146f.setTitleText(R.string.invite_contact_title);
            } else {
                this.s = this.f62146f.setTitleText(R.string.invite_friend);
            }
            View addCustomView = this.f62146f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View$OnClickListenerC1535d(this));
            this.u = addCustomView;
            this.y = (ImageView) addCustomView.findViewById(R.id.new_friend_search);
            View addCustomView2 = this.f62146f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
            this.t = addCustomView2;
            addCustomView2.setVisibility(8);
            EditText editText = (EditText) this.t.findViewById(R.id.search_bar_edit);
            this.v = editText;
            if (editText.getParent() != null) {
                ((View) this.v.getParent()).setFocusable(true);
                ((View) this.v.getParent()).setFocusableInTouchMode(true);
            }
            e eVar = new e(this);
            this.x = eVar;
            this.v.addTextChangedListener(eVar);
            TextView textView = (TextView) this.t.findViewById(R.id.search_bar_delete_button);
            this.w = textView;
            textView.setOnClickListener(new f(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62145e.setContentView(R.layout.invite_friend_list);
            this.f62147g = this.f62145e.findViewById(R.id.root_view);
            B();
            BdListView bdListView = (BdListView) this.f62147g.findViewById(R.id.friend_list);
            this.f62148h = bdListView;
            bdListView.setOnItemClickListener(this.f62145e);
            if (this.r) {
                this.j = NoDataViewFactory.a(this.f62145e.getPageContext().getPageActivity(), this.f62147g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13179a), NoDataViewFactory.e.b(R.string.no_friends, R.string.no_friends_tip), null);
            } else {
                this.j = NoDataViewFactory.a(this.f62145e.getPageContext().getPageActivity(), this.f62147g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.f13179a), NoDataViewFactory.e.b(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.c.a(new NoDataViewFactory.b(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new a(this))));
            }
            this.k = (ProgressBar) this.f62147g.findViewById(R.id.progress);
            InviteFriendCandidateList inviteFriendCandidateList = (InviteFriendCandidateList) this.f62147g.findViewById(R.id.candidate_list);
            this.m = inviteFriendCandidateList;
            inviteFriendCandidateList.n(new b(this));
            this.n = (LinearLayout) this.f62147g.findViewById(R.id.invite_candidate);
            this.l = this.f62147g.findViewById(R.id.invite_candidate_border);
            if (this.r) {
                this.n.setVisibility(8);
                this.l.setVisibility(8);
            }
            r();
            Button button = (Button) this.f62147g.findViewById(R.id.button_send);
            this.o = button;
            button.setOnClickListener(this.f62145e);
            s();
            N();
            K(0);
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.t;
            return view != null && view.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.v.removeTextChangedListener(this.x);
        }
    }

    public void I(List<d.a.r0.s.f.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, list, z) == null) {
            if (this.f62149i == null) {
                d.a.s0.j1.a.c.c cVar = new d.a.s0.j1.a.c.c(this.f62145e, this.r);
                this.f62149i = cVar;
                cVar.f(this);
                this.f62149i.d(new h(this));
                this.f62148h.setAdapter((ListAdapter) this.f62149i);
            }
            if (!z && list.isEmpty()) {
                this.j.setVisibility(0);
                this.f62148h.setVisibility(8);
                if (this.r) {
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.j.setVisibility(8);
            this.f62148h.setVisibility(0);
            this.f62149i.e(list);
            this.f62149i.notifyDataSetChanged();
            if (this.r) {
                return;
            }
            this.n.setVisibility(0);
        }
    }

    public void J(d.a.r0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null) {
            return;
        }
        this.m.l(aVar);
        K(this.m.getItemLength());
        O();
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.o.setText(String.format(this.f62145e.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i2)));
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.q = i2;
            this.m.setMaxCount(i2);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f62148h.setOnTouchListener(new g(this));
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.m.getItemLength() > 0) {
                this.o.setEnabled(true);
            } else {
                this.o.setEnabled(false);
            }
        }
    }

    @Override // d.a.s0.j1.a.c.c.b
    public void c(View view, d.a.r0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, aVar) == null) || aVar == null) {
            return;
        }
        this.m.h(aVar);
    }

    public void d() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.d(this.f62145e.getPageContext());
    }

    public void e() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.e();
    }

    public void q(d.a.r0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null) {
            return;
        }
        this.m.e(aVar);
        K(this.m.getItemLength());
        O();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int dimensionPixelSize = this.f62145e.getResources().getDimensionPixelSize(R.dimen.ds80) + this.f62145e.getResources().getDimensionPixelSize(R.dimen.ds16) + this.f62145e.getResources().getDimensionPixelSize(R.dimen.ds16);
            View view = new View(this.f62145e.getPageContext().getPageActivity());
            this.p = view;
            view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            this.p.setEnabled(false);
            this.f62148h.addFooterView(this.p);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f62145e.getLayoutMode().k(skinType == 1);
            this.f62145e.getLayoutMode().j(this.f62147g);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.y, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
            this.f62146f.onChangeSkinType(this.f62145e.getPageContext(), skinType);
            this.j.f(this.f62145e.getPageContext(), skinType);
            SkinManager.setBackgroundResource(this.p, R.drawable.invite_friend_list_item_bg_color);
            this.p.setEnabled(false);
        }
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m.g() : (String) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.q : invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o.getId() : invokeV.intValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f62147g : (View) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Editable text = this.v.getText();
            return text != null ? text.toString() : "";
        }
        return (String) invokeV.objValue;
    }

    public final void y() {
        InviteFriendListActivity inviteFriendListActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (inviteFriendListActivity = this.f62145e) == null) {
            return;
        }
        inviteFriendListActivity.refreshWithCurrentData();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            l.x(this.f62145e.getPageContext().getPageActivity(), this.v);
        }
    }
}
