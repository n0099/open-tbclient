package d.a.q0.i1.r;

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
import d.a.d.a.d;
import d.a.d.a.f;
/* loaded from: classes8.dex */
public class a extends d<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f59221a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59222b;

    /* renamed from: c  reason: collision with root package name */
    public View f59223c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f59224d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f59225e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f59226f;

    /* renamed from: g  reason: collision with root package name */
    public View f59227g;

    /* renamed from: h  reason: collision with root package name */
    public View f59228h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f59229i;

    /* renamed from: d.a.q0.i1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1479a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59230e;

        public C1479a(a aVar) {
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
            this.f59230e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f59230e.f59227g.setTag(editable.toString().trim());
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
                if (this.f59230e.f59224d.length() > 0) {
                    this.f59230e.f59225e.setVisibility(0);
                } else {
                    this.f59230e.f59225e.setVisibility(8);
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
        this.f59221a = null;
        this.f59222b = null;
        this.f59223c = null;
        this.f59224d = null;
        this.f59225e = null;
        this.f59226f = null;
        this.f59227g = null;
        this.f59229i = null;
        this.f59229i = addGroupActivity;
        initUI();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f59229i.getLayoutMode().k(i2 == 1);
            this.f59229i.getLayoutMode().j(this.f59221a);
            this.f59222b.onChangeSkinType(this.f59229i.getPageContext(), i2);
        }
    }

    public void h() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f59224d) == null) {
            return;
        }
        editText.setText("");
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59229i.setContentView(R.layout.im_add_group_activity);
            this.f59221a = this.f59229i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f59229i.findViewById(R.id.addgroup_navigationbar);
            this.f59222b = navigationBar;
            this.f59223c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f59222b.setTitleText(this.f59229i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f59229i.findViewById(R.id.addgroup_input);
            this.f59224d = editText;
            editText.setInputType(2);
            this.f59225e = (ImageButton) this.f59229i.findViewById(R.id.addgroup_delbtn);
            this.f59227g = this.f59229i.findViewById(R.id.addgroup_searchbutton);
            this.f59228h = this.f59229i.findViewById(R.id.addgroup_vcode);
            this.f59224d.addTextChangedListener(new C1479a(this));
            this.f59227g = this.f59229i.findViewById(R.id.addgroup_searchbutton);
            this.f59226f = (ProgressBar) this.f59229i.findViewById(R.id.addgroup_progress);
            this.f59223c.setOnClickListener(this.f59229i);
            this.f59225e.setOnClickListener(this.f59229i);
            this.f59227g.setOnClickListener(this.f59229i);
            this.f59228h.setOnClickListener(this.f59229i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f59228h.setVisibility(8);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59223c : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59225e : (View) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59227g : (View) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59228h : (View) invokeV.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f59226f.setVisibility(z ? 0 : 8);
        }
    }
}
