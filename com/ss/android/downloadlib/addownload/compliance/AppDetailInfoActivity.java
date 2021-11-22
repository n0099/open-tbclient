package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.R;
import java.util.List;
/* loaded from: classes2.dex */
public class AppDetailInfoActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f69469a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f69470b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f69471c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f69472d;

    /* renamed from: e  reason: collision with root package name */
    public long f69473e;

    /* renamed from: f  reason: collision with root package name */
    public long f69474f;

    /* renamed from: g  reason: collision with root package name */
    public List<Pair<String, String>> f69475g;

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.Adapter<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppDetailInfoActivity f69478a;

        public a(AppDetailInfoActivity appDetailInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appDetailInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69478a = appDetailInfoActivity;
        }
    }

    public AppDetailInfoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f69469a = (ImageView) findViewById(R.id.iv_detail_back);
            this.f69470b = (TextView) findViewById(R.id.tv_empty);
            this.f69472d = (RecyclerView) findViewById(R.id.permission_list);
            this.f69471c = (LinearLayout) findViewById(R.id.ll_download);
            if (this.f69475g.isEmpty()) {
                this.f69472d.setVisibility(8);
                this.f69470b.setVisibility(0);
            } else {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(1);
                this.f69472d.setLayoutManager(linearLayoutManager);
                this.f69472d.setAdapter(new a());
            }
            this.f69469a.setOnClickListener(new View.OnClickListener(this) { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AppDetailInfoActivity f69476a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69476a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        e.a("lp_app_detail_click_close", this.f69476a.f69474f);
                        this.f69476a.finish();
                    }
                }
            });
            this.f69471c.setOnClickListener(new View.OnClickListener(this) { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AppDetailInfoActivity f69477a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69477a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        e.a("lp_app_detail_click_download", this.f69477a.f69474f);
                        b.a().b(this.f69477a.f69474f);
                        com.ss.android.socialbase.appdownloader.c.a((Activity) this.f69477a);
                        com.ss.android.socialbase.appdownloader.c.a(b.a().b());
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e.a("lp_app_detail_click_close", this.f69474f);
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.ttdownloader_activity_app_detail_info);
            if (a()) {
                b();
            } else {
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            }
            LogUtil.logActivity(this, "onCreate");
        }
    }

    public static void a(Activity activity, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65538, null, activity, j) == null) {
            Intent intent = new Intent(activity, AppDetailInfoActivity.class);
            intent.putExtra("app_info_id", j);
            activity.startActivity(intent);
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            this.f69473e = getIntent().getLongExtra("app_info_id", 0L);
            com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(this.f69473e);
            if (a2 == null) {
                return false;
            }
            this.f69474f = a2.f69407b;
            this.f69475g = a2.f69413h;
            return true;
        }
        return invokeV.booleanValue;
    }
}
