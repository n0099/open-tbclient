package d.a.p0.i1.r;

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
/* loaded from: classes8.dex */
public class a extends d<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f58607a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f58608b;

    /* renamed from: c  reason: collision with root package name */
    public View f58609c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f58610d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f58611e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f58612f;

    /* renamed from: g  reason: collision with root package name */
    public View f58613g;

    /* renamed from: h  reason: collision with root package name */
    public View f58614h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f58615i;

    /* renamed from: d.a.p0.i1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1474a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58616e;

        public C1474a(a aVar) {
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
            this.f58616e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f58616e.f58613g.setTag(editable.toString().trim());
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
                if (this.f58616e.f58610d.length() > 0) {
                    this.f58616e.f58611e.setVisibility(0);
                } else {
                    this.f58616e.f58611e.setVisibility(8);
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
        this.f58607a = null;
        this.f58608b = null;
        this.f58609c = null;
        this.f58610d = null;
        this.f58611e = null;
        this.f58612f = null;
        this.f58613g = null;
        this.f58615i = null;
        this.f58615i = addGroupActivity;
        initUI();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f58615i.getLayoutMode().k(i2 == 1);
            this.f58615i.getLayoutMode().j(this.f58607a);
            this.f58608b.onChangeSkinType(this.f58615i.getPageContext(), i2);
        }
    }

    public void h() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f58610d) == null) {
            return;
        }
        editText.setText("");
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f58615i.setContentView(R.layout.im_add_group_activity);
            this.f58607a = this.f58615i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f58615i.findViewById(R.id.addgroup_navigationbar);
            this.f58608b = navigationBar;
            this.f58609c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f58608b.setTitleText(this.f58615i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f58615i.findViewById(R.id.addgroup_input);
            this.f58610d = editText;
            editText.setInputType(2);
            this.f58611e = (ImageButton) this.f58615i.findViewById(R.id.addgroup_delbtn);
            this.f58613g = this.f58615i.findViewById(R.id.addgroup_searchbutton);
            this.f58614h = this.f58615i.findViewById(R.id.addgroup_vcode);
            this.f58610d.addTextChangedListener(new C1474a(this));
            this.f58613g = this.f58615i.findViewById(R.id.addgroup_searchbutton);
            this.f58612f = (ProgressBar) this.f58615i.findViewById(R.id.addgroup_progress);
            this.f58609c.setOnClickListener(this.f58615i);
            this.f58611e.setOnClickListener(this.f58615i);
            this.f58613g.setOnClickListener(this.f58615i);
            this.f58614h.setOnClickListener(this.f58615i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f58614h.setVisibility(8);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58609c : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58611e : (View) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58613g : (View) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58614h : (View) invokeV.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f58612f.setVisibility(z ? 0 : 8);
        }
    }
}
