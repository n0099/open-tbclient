package d.a.s0.s.e.b;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EditText f65197a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f65198b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f65199c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f65200d;

    /* renamed from: e  reason: collision with root package name */
    public c f65201e;

    /* renamed from: f  reason: collision with root package name */
    public Context f65202f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f65203g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f65204h;

    /* renamed from: d.a.s0.s.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1665a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65205e;

        public View$OnClickListenerC1665a(a aVar) {
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
            this.f65205e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f65205e.f65198b) {
                    String charSequence2String = k.charSequence2String(this.f65205e.f65197a.getText(), null);
                    if (StringUtils.isNULL(charSequence2String)) {
                        return;
                    }
                    if (charSequence2String.trim().length() != 0) {
                        this.f65205e.i(charSequence2String.trim());
                        this.f65205e.f65198b.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        this.f65205e.f65203g.showToast(R.string.input_content);
                    }
                } else if (view == this.f65205e.f65199c) {
                    this.f65205e.k("");
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65206e;

        public b(a aVar) {
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
            this.f65206e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (TextUtils.isEmpty(editable)) {
                    this.f65206e.f65199c.setVisibility(8);
                } else {
                    this.f65206e.f65199c.setVisibility(0);
                }
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
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(String str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65204h = new View$OnClickListenerC1665a(this);
        this.f65203g = tbPageContext;
        this.f65202f = tbPageContext.getPageActivity();
        this.f65197a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f65198b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f65199c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f65198b.setOnClickListener(this.f65204h);
        this.f65199c.setOnClickListener(this.f65204h);
        b bVar = new b(this);
        this.f65200d = bVar;
        this.f65197a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            SkinManager.setViewTextColor(this.f65198b, R.color.CAM_X0111, 1);
            this.f65197a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setImageResource(this.f65199c, R.drawable.icon_search_close);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l.x(this.f65202f, this.f65197a);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65197a.removeTextChangedListener(this.f65200d);
        }
    }

    public final void i(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (cVar = this.f65201e) == null) {
            return;
        }
        cVar.a(str);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f65198b.setClickable(z);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f65197a.setText(str);
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f65201e = cVar;
        }
    }
}
