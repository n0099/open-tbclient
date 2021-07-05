package d.a.s0.i1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
/* loaded from: classes9.dex */
public class b extends d.a.c.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f61941b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f61942c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61943d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61944e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61945f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61946g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f61947h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f61948i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61949e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61949e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61949e.f61947h.onItemViewClick(this.f61949e.f61946g, 100, 0, 0L, this.f61949e.f61948i);
            }
        }
    }

    /* renamed from: d.a.s0.i1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1524b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61950e;

        public View$OnClickListenerC1524b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61950e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61950e.f61947h.onItemViewClick(this.f61950e.f61942c, 101, 0, 0L, this.f61950e.f61948i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61951e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61951e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f61951e.f61947h.onItemViewLongClick(this.f61951e.f61941b, 200, 0, 0L, this.f61951e.f61948i);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61947h = validateActivity;
        l();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f43865a.findViewById(R.id.root_view);
            this.f61941b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f61942c = headImageView;
            headImageView.setIsRound(false);
            this.f61943d = (TextView) this.f61941b.findViewById(R.id.tv_user_name);
            this.f61944e = (TextView) this.f61941b.findViewById(R.id.tv_group_name);
            this.f61945f = (TextView) this.f61941b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f61941b.findViewById(R.id.btn_pass);
            this.f61946g = textView;
            textView.setOnClickListener(new a(this));
            this.f61942c.setOnClickListener(new View$OnClickListenerC1524b(this));
            this.f61941b.setOnLongClickListener(new c(this));
        }
    }

    public void m(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, validateItemData) == null) {
            n(validateItemData);
            refresh();
        }
    }

    public void n(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, validateItemData) == null) {
            this.f61948i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f61948i == null) {
            return;
        }
        this.f61947h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f61947h.getLayoutMode().j(this.f61941b);
        String portrait = this.f61948i.getPortrait();
        this.f61942c.setTag(portrait);
        this.f61942c.M(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f61948i.getUserName())) {
            this.f61943d.setText(this.f61948i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f61948i.getGroupName())) {
            TextView textView = this.f61944e;
            textView.setText(this.f61947h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f61948i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f61948i.getApplyReason())) {
            TextView textView2 = this.f61945f;
            textView2.setText(this.f61947h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f61948i.getApplyReason());
        }
        if (this.f61948i.isPass()) {
            this.f61946g.setEnabled(false);
            this.f61946g.setText(this.f61947h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f61946g, R.color.CAM_X0109);
            this.f61946g.setBackgroundDrawable(null);
        } else {
            this.f61946g.setEnabled(true);
            this.f61946g.setText(this.f61947h.getPageContext().getString(R.string.pass));
        }
        if (this.f61948i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f61941b, R.color.common_color_10178);
    }
}
