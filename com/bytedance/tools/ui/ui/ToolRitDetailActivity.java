package com.bytedance.tools.ui.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.baidu.tieba.R;
import com.baidu.tieba.bmb;
import com.baidu.tieba.emb;
import com.baidu.tieba.fmb;
import com.baidu.tieba.vlb;
import com.baidu.tieba.xlb;
import com.baidu.tieba.zlb;
import com.bytedance.tools.ui.view.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ToolRitDetailActivity extends AppCompatActivity {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public Button f;
    public Button g;
    public RadioGroup h;
    public d i;
    public com.bytedance.tools.ui.view.a j;
    public xlb k;
    public List<vlb> l;
    public int m;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ToolRitDetailActivity.this.s1(-1);
            ToolRitDetailActivity.this.m = 0;
            ToolRitDetailActivity.this.C1();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ToolRitDetailActivity.this.C1();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements RadioGroup.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == -1) {
                ToolRitDetailActivity.this.f.setEnabled(false);
                return;
            }
            ToolRitDetailActivity.this.f.setEnabled(true);
            ToolRitDetailActivity.this.m = i;
            ToolRitDetailActivity.this.s1(i);
        }
    }

    public final void a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.k = xlb.b(intent.getStringExtra("rit_info"));
        }
        xlb a2 = xlb.a(this, this.k.a);
        this.k = a2;
        fmb.d(this, "test_tool_slot_info_detail", a2.a, null, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0052);
        a();
        b();
        A1();
    }

    public final void A1() {
        TextView textView = this.a;
        textView.setText(this.k.b + "");
        this.b.setText(this.k.a);
        TextView textView2 = this.c;
        textView2.setText(this.k.c + ":" + this.k.d);
        TextView textView3 = this.d;
        textView3.setText(this.k.e + ":" + this.k.f);
        TextView textView4 = this.e;
        textView4.setText(this.k.g + "");
    }

    public final void b() {
        emb.a(this, (Toolbar) findViewById(R.id.obfuscated_res_0x7f092644), "代码位检测详情页");
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091f95);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f89);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091f8a);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091f87);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091f83);
        this.f = (Button) findViewById(R.id.obfuscated_res_0x7f091f8d);
        this.g = (Button) findViewById(R.id.obfuscated_res_0x7f091f90);
        this.h = (RadioGroup) findViewById(R.id.obfuscated_res_0x7f091f8e);
        this.f.setOnClickListener(new a());
        this.g.setOnClickListener(new b());
        this.h.setOnCheckedChangeListener(new c());
        y1();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092 A[Catch: IOException -> 0x008e, TRY_LEAVE, TryCatch #8 {IOException -> 0x008e, blocks: (B:47:0x008a, B:51:0x0092), top: B:64:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B1() {
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        JSONArray jSONArray = null;
        try {
            inputStreamReader = new InputStreamReader(getAssets().open("previewIds_new.json"));
        } catch (Exception e) {
            e = e;
            inputStreamReader = null;
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
            inputStreamReader = null;
        }
        try {
            bufferedReader = new BufferedReader(inputStreamReader);
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    JSONArray jSONArray2 = new JSONArray(sb.toString());
                    try {
                        bufferedReader.close();
                        inputStreamReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray = jSONArray2;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    this.l = new ArrayList();
                    if (jSONArray != null) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            throw th;
        }
        this.l = new ArrayList();
        if (jSONArray != null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.l.add(new vlb(jSONArray.getJSONObject(i)));
            } catch (JSONException e7) {
                e7.printStackTrace();
                return;
            }
        }
    }

    public final void C1() {
        int i = this.m;
        if (i == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("config", "");
            bmb.a(this, "setting_rit", contentValues, "rit=?", new String[]{this.k.a});
            Toast.makeText(this, "清除成功", 0).show();
            fmb.d(this, "test_preview", this.k.a, "", "");
            return;
        }
        com.bytedance.tools.ui.view.c cVar = (com.bytedance.tools.ui.view.c) findViewById(i);
        if (cVar.d()) {
            Toast.makeText(this, "参数不合法，请重新设置", 0).show();
            return;
        }
        vlb configModel = cVar.getConfigModel();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", configModel.a());
            jSONObject.put("cid", configModel.d());
            fmb.d(this, "test_preview", this.k.a, configModel.a(), configModel.d());
            if ("1696550504417319".equals(configModel.a()) && "1696824047861763".equals(configModel.d())) {
                jSONObject.put("ext", "{\"style_ids\":{\"playable_id\":1}}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String c2 = zlb.c(jSONObject.toString());
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("config", c2);
        bmb.a(this, "setting_rit", contentValues2, "rit=?", new String[]{this.k.a});
        Toast.makeText(this, "保存成功", 0).show();
    }

    public final void s1(int i) {
        boolean z;
        if (i == -1) {
            this.h.clearCheck();
            this.i.h();
            this.j.e();
        }
        for (int i2 = 0; i2 < this.h.getChildCount(); i2++) {
            com.bytedance.tools.ui.view.c cVar = (com.bytedance.tools.ui.view.c) this.h.getChildAt(i2);
            if (cVar.getId() == i) {
                z = true;
            } else {
                z = false;
            }
            cVar.setChecked(z);
        }
    }

    public final void y1() {
        B1();
        xlb xlbVar = this.k;
        vlb vlbVar = new vlb(xlbVar.h, xlbVar.i);
        this.i = new d(this, this.h, vlbVar, this.l);
        this.j = new com.bytedance.tools.ui.view.a(this, this.h, vlbVar, this.l);
        this.h.addView(this.i);
        this.h.addView(this.j);
        if (this.i.m()) {
            this.h.check(this.i.getId());
        } else {
            this.h.check(this.j.getId());
        }
    }
}
