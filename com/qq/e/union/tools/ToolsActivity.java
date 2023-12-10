package com.qq.e.union.tools;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.union.tools.ToolsActivity;
import com.qq.e.union.tools.view.MockFloatWindowManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class ToolsActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Spinner a;
    public Spinner b;
    public CheckBox c;
    public List<String> d;
    public List<String> e;
    public f f;
    public f g;
    public String h;
    public String i;
    public SharedPreferences j;
    public SharedPreferences.Editor k;

    public ToolsActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view2) {
        this.k.putInt("ifs", this.c.isChecked() ? 1 : 0);
        this.k.apply();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("gdt_mock", 0);
            this.j = sharedPreferences;
            this.k = sharedPreferences.edit();
            Button button = (Button) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0907ea);
            Button button2 = (Button) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090574);
            this.a = (Spinner) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0900a2);
            this.b = (Spinner) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09086c);
            this.c = (CheckBox) findViewById(com.baidu.tieba.R.id.isFullscreenCheckBox);
            this.d = new ArrayList(Arrays.asList(getResources().getStringArray(com.baidu.tieba.R.array.obfuscated_res_0x7f030019)));
            this.e = new ArrayList(Arrays.asList(getResources().getStringArray(com.baidu.tieba.R.array.obfuscated_res_0x7f030011)));
            f fVar = new f(this, 17367048, getResources().getStringArray(com.baidu.tieba.R.array.obfuscated_res_0x7f030019));
            this.f = fVar;
            fVar.setDropDownViewResource(17367049);
            f fVar2 = new f(this, 17367048, getResources().getStringArray(com.baidu.tieba.R.array.obfuscated_res_0x7f030011));
            this.g = fVar2;
            fVar2.setDropDownViewResource(17367049);
            this.a.setAdapter((SpinnerAdapter) this.f);
            this.b.setAdapter((SpinnerAdapter) this.g);
            int i = this.j.getInt("pt", -1);
            int i2 = this.j.getInt("cs", -1);
            int i3 = this.j.getInt("ifs", 0);
            if (i2 != -1) {
                this.b.setSelection(i2);
            }
            if (i != -1) {
                this.a.setSelection(i);
            }
            if (i3 == 1) {
                this.c.setChecked(true);
            }
            this.a.setOnItemSelectedListener(new a(this));
            this.b.setOnItemSelectedListener(new b(this));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sec
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ToolsActivity.this.a(view2);
                    }
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tec
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ToolsActivity.this.b(view2);
                    }
                }
            });
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.uec
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ToolsActivity.this.c(view2);
                    }
                }
            });
        }
    }

    public final void a(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && file != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    a(file2);
                } else {
                    file2.delete();
                }
            }
            file.delete();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(com.baidu.tieba.R.layout.gdt_activity_tools);
            a();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            MockFloatWindowManager.getInstance().needHide(false);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            MockFloatWindowManager.getInstance().needHide(true);
        }
    }

    /* loaded from: classes10.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ToolsActivity a;

        public a(ToolsActivity toolsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toolsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = toolsActivity;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adapterView) == null) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ToolsActivity toolsActivity = this.a;
                toolsActivity.h = toolsActivity.a.getSelectedItem().toString();
                this.a.f.a = i;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ToolsActivity a;

        public b(ToolsActivity toolsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toolsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = toolsActivity;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adapterView) == null) {
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ToolsActivity toolsActivity = this.a;
                toolsActivity.i = toolsActivity.b.getSelectedItem().toString();
                this.a.g.a = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, view2) == null) {
            this.k.putInt("pt", this.d.indexOf(this.h));
            this.k.putInt("cs", this.e.indexOf(this.i));
            this.k.putInt("ifs", this.c.isChecked() ? 1 : 0);
            this.k.apply();
            a(getDir("adnet", 0));
            MockFloatWindowManager.getInstance().changeState(true);
            Toast.makeText(this, "mock成功！", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, view2) == null) {
            this.k.clear();
            this.k.apply();
            Toast.makeText(this, "取消mock成功！", 0).show();
            this.a.setSelection(0);
            this.b.setSelection(0);
            this.c.setChecked(false);
            MockFloatWindowManager.getInstance().changeState(false);
        }
    }
}
