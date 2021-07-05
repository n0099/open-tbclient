package d.a.s0.i1.r;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.a.f;
/* loaded from: classes9.dex */
public class a extends d<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f61842a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f61843b;

    /* renamed from: c  reason: collision with root package name */
    public View f61844c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f61845d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f61846e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f61847f;

    /* renamed from: g  reason: collision with root package name */
    public View f61848g;

    /* renamed from: h  reason: collision with root package name */
    public View f61849h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f61850i;

    /* renamed from: d.a.s0.i1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1518a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61851e;

        public C1518a(a aVar) {
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
            this.f61851e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f61851e.f61848g.setTag(editable.toString().trim());
            }
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
                if (this.f61851e.f61845d.length() > 0) {
                    this.f61851e.f61846e.setVisibility(0);
                } else {
                    this.f61851e.f61846e.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {addGroupActivity};
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
        this.f61842a = null;
        this.f61843b = null;
        this.f61844c = null;
        this.f61845d = null;
        this.f61846e = null;
        this.f61847f = null;
        this.f61848g = null;
        this.f61850i = null;
        this.f61850i = addGroupActivity;
        initUI();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f61850i.getLayoutMode().k(i2 == 1);
            this.f61850i.getLayoutMode().j(this.f61842a);
            this.f61843b.onChangeSkinType(this.f61850i.getPageContext(), i2);
        }
    }

    public void h() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f61845d) == null) {
            return;
        }
        editText.setText("");
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61844c : (View) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f61850i.setContentView(R.layout.im_add_group_activity);
            this.f61842a = this.f61850i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f61850i.findViewById(R.id.addgroup_navigationbar);
            this.f61843b = navigationBar;
            this.f61844c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f61843b.setTitleText(this.f61850i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f61850i.findViewById(R.id.addgroup_input);
            this.f61845d = editText;
            editText.setInputType(2);
            this.f61846e = (ImageButton) this.f61850i.findViewById(R.id.addgroup_delbtn);
            this.f61848g = this.f61850i.findViewById(R.id.addgroup_searchbutton);
            this.f61849h = this.f61850i.findViewById(R.id.addgroup_vcode);
            this.f61845d.addTextChangedListener(new C1518a(this));
            this.f61848g = this.f61850i.findViewById(R.id.addgroup_searchbutton);
            this.f61847f = (ProgressBar) this.f61850i.findViewById(R.id.addgroup_progress);
            this.f61844c.setOnClickListener(this.f61850i);
            this.f61846e.setOnClickListener(this.f61850i);
            this.f61848g.setOnClickListener(this.f61850i);
            this.f61849h.setOnClickListener(this.f61850i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f61849h.setVisibility(8);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61846e : (View) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61848g : (View) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61849h : (View) invokeV.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f61847f.setVisibility(z ? 0 : 8);
        }
    }
}
