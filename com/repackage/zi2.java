package com.repackage;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zi2 extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity a;
    public EditText b;
    public String[] c;
    public int d;
    public d e;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ zi2 b;

        public a(zi2 zi2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zi2Var;
            this.a = i;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                int selectionStart = this.b.b.getSelectionStart();
                Editable text = this.b.b.getText();
                if (i == 11) {
                    if (selectionStart <= 0 || text == null || text.length() <= 0) {
                        return;
                    }
                    int i2 = selectionStart - 1;
                    text.delete(i2, selectionStart);
                    this.b.b.setText(text);
                    this.b.b.setSelection(i2);
                    return;
                }
                int length = text.length();
                int i3 = this.a;
                if (length < i3 || i3 < 0) {
                    text.insert(selectionStart, this.b.c[i]);
                    this.b.b.setText(text);
                    this.b.b.setSelection(selectionStart + this.b.c[i].length());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridView a;
        public final /* synthetic */ AdapterView.OnItemClickListener b;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int intValue = ((Integer) view2.getTag()).intValue();
                    b bVar = this.a;
                    bVar.b.onItemClick(bVar.a, view2, intValue, intValue);
                }
            }
        }

        public b(zi2 zi2Var, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi2Var, gridView, onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gridView;
            this.b = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int childCount = this.a.getChildCount();
                if (childCount > 0) {
                    this.a.setClickable(false);
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.a.getChildAt(i);
                        childAt.setTag(Integer.valueOf(i));
                        childAt.setOnClickListener(new a(this));
                    }
                    return;
                }
                this.a.setOnItemClickListener(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi2 a;

        public c(zi2 zi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zi2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                this.a.b.clearFocus();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();

        void b(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zi2(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i, int i2) {
        super(swanAppActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, editText, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new String[12];
        c(i);
        d(swanAppActivity, editText, i2);
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i2 = 0;
            while (i2 < 9) {
                int i3 = i2 + 1;
                this.c[i2] = String.valueOf(i3);
                i2 = i3;
            }
            if (i == 1) {
                this.c[9] = "X";
            } else if (i == 0) {
                this.c[9] = "";
            } else if (i == 2) {
                this.c[9] = ".";
            }
            this.c[10] = "0";
        }
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, editText, i) == null) {
            this.a = swanAppActivity;
            this.b = editText;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(R.layout.obfuscated_res_0x7f0d00b2, (ViewGroup) null);
            this.d = swanAppActivity.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            GridView gridView = (GridView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090fd4);
            gridView.setAdapter((ListAdapter) new yi2(swanAppActivity, this.c));
            be3.a0(new b(this, gridView, new a(this, i)));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09062d);
            imageView.setOnClickListener(new c(this));
            imageView.setClickable(true);
            setContentView(linearLayout);
            setWidth(-1);
            setHeight(this.d);
            setBackgroundDrawable(new BitmapDrawable());
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            d dVar = this.e;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void e(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.e = dVar;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isShowing()) {
            return;
        }
        showAtLocation(this.a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.e;
        if (dVar != null) {
            dVar.b(this.d);
        }
    }
}
