package d.a.p0.i1.x;

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
/* loaded from: classes8.dex */
public class b extends d.a.c.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f58706b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f58707c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58708d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58709e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58710f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58711g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f58712h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f58713i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f58714e;

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
            this.f58714e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58714e.f58712h.onItemViewClick(this.f58714e.f58711g, 100, 0, 0L, this.f58714e.f58713i);
            }
        }
    }

    /* renamed from: d.a.p0.i1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1480b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f58715e;

        public View$OnClickListenerC1480b(b bVar) {
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
            this.f58715e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58715e.f58712h.onItemViewClick(this.f58715e.f58707c, 101, 0, 0L, this.f58715e.f58713i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f58716e;

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
            this.f58716e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f58716e.f58712h.onItemViewLongClick(this.f58716e.f58706b, 200, 0, 0L, this.f58716e.f58713i);
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
        this.f58712h = validateActivity;
        l();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f40881a.findViewById(R.id.root_view);
            this.f58706b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f58707c = headImageView;
            headImageView.setIsRound(false);
            this.f58708d = (TextView) this.f58706b.findViewById(R.id.tv_user_name);
            this.f58709e = (TextView) this.f58706b.findViewById(R.id.tv_group_name);
            this.f58710f = (TextView) this.f58706b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f58706b.findViewById(R.id.btn_pass);
            this.f58711g = textView;
            textView.setOnClickListener(new a(this));
            this.f58707c.setOnClickListener(new View$OnClickListenerC1480b(this));
            this.f58706b.setOnLongClickListener(new c(this));
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
            this.f58713i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f58713i == null) {
            return;
        }
        this.f58712h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f58712h.getLayoutMode().j(this.f58706b);
        String portrait = this.f58713i.getPortrait();
        this.f58707c.setTag(portrait);
        this.f58707c.M(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f58713i.getUserName())) {
            this.f58708d.setText(this.f58713i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f58713i.getGroupName())) {
            TextView textView = this.f58709e;
            textView.setText(this.f58712h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f58713i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f58713i.getApplyReason())) {
            TextView textView2 = this.f58710f;
            textView2.setText(this.f58712h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f58713i.getApplyReason());
        }
        if (this.f58713i.isPass()) {
            this.f58711g.setEnabled(false);
            this.f58711g.setText(this.f58712h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f58711g, R.color.CAM_X0109);
            this.f58711g.setBackgroundDrawable(null);
        } else {
            this.f58711g.setEnabled(true);
            this.f58711g.setText(this.f58712h.getPageContext().getString(R.string.pass));
        }
        if (this.f58713i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f58706b, R.color.common_color_10178);
    }
}
