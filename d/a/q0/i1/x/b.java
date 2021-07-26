package d.a.q0.i1.x;

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
import d.a.d.a.f;
/* loaded from: classes8.dex */
public class b extends d.a.d.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f59320b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f59321c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59322d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59323e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59324f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59325g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f59326h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f59327i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59328e;

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
            this.f59328e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59328e.f59326h.onItemViewClick(this.f59328e.f59325g, 100, 0, 0L, this.f59328e.f59327i);
            }
        }
    }

    /* renamed from: d.a.q0.i1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1485b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59329e;

        public View$OnClickListenerC1485b(b bVar) {
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
            this.f59329e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59329e.f59326h.onItemViewClick(this.f59329e.f59321c, 101, 0, 0L, this.f59329e.f59327i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59330e;

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
            this.f59330e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f59330e.f59326h.onItemViewLongClick(this.f59330e.f59320b, 200, 0, 0L, this.f59330e.f59327i);
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
        this.f59326h = validateActivity;
        l();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f41385a.findViewById(R.id.root_view);
            this.f59320b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f59321c = headImageView;
            headImageView.setIsRound(false);
            this.f59322d = (TextView) this.f59320b.findViewById(R.id.tv_user_name);
            this.f59323e = (TextView) this.f59320b.findViewById(R.id.tv_group_name);
            this.f59324f = (TextView) this.f59320b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f59320b.findViewById(R.id.btn_pass);
            this.f59325g = textView;
            textView.setOnClickListener(new a(this));
            this.f59321c.setOnClickListener(new View$OnClickListenerC1485b(this));
            this.f59320b.setOnLongClickListener(new c(this));
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
            this.f59327i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f59327i == null) {
            return;
        }
        this.f59326h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f59326h.getLayoutMode().j(this.f59320b);
        String portrait = this.f59327i.getPortrait();
        this.f59321c.setTag(portrait);
        this.f59321c.M(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f59327i.getUserName())) {
            this.f59322d.setText(this.f59327i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f59327i.getGroupName())) {
            TextView textView = this.f59323e;
            textView.setText(this.f59326h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f59327i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f59327i.getApplyReason())) {
            TextView textView2 = this.f59324f;
            textView2.setText(this.f59326h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f59327i.getApplyReason());
        }
        if (this.f59327i.isPass()) {
            this.f59325g.setEnabled(false);
            this.f59325g.setText(this.f59326h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f59325g, R.color.CAM_X0109);
            this.f59325g.setBackgroundDrawable(null);
        } else {
            this.f59325g.setEnabled(true);
            this.f59325g.setText(this.f59326h.getPageContext().getString(R.string.pass));
        }
        if (this.f59327i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f59320b, R.color.common_color_10178);
    }
}
