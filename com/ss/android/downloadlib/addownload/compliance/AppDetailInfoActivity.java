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
import c.p.a.d.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.adhost.R;
import java.util.List;
/* loaded from: classes10.dex */
public class AppDetailInfoActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f75499a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75500b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f75501c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f75502d;

    /* renamed from: e  reason: collision with root package name */
    public long f75503e;

    /* renamed from: f  reason: collision with root package name */
    public long f75504f;

    /* renamed from: g  reason: collision with root package name */
    public List<Pair<String, String>> f75505g;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppDetailInfoActivity f75506e;

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
            this.f75506e = appDetailInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.p.a.d.b.e.b.c("lp_app_detail_click_close", this.f75506e.f75504f);
                this.f75506e.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppDetailInfoActivity f75507e;

        public b(AppDetailInfoActivity appDetailInfoActivity) {
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
            this.f75507e = appDetailInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.p.a.d.b.e.b.c("lp_app_detail_click_download", this.f75507e.f75504f);
                c.p.a.d.b.e.a.a().i(this.f75507e.f75504f);
                c.p.a.e.a.d.q(this.f75507e);
                c.p.a.e.a.d.q(c.p.a.d.b.e.a.a().h());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends RecyclerView.Adapter<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppDetailInfoActivity f75508a;

        public c(AppDetailInfoActivity appDetailInfoActivity) {
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
            this.f75508a = appDetailInfoActivity;
        }

        public /* synthetic */ c(AppDetailInfoActivity appDetailInfoActivity, a aVar) {
            this(appDetailInfoActivity);
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
            this.f75499a = (ImageView) findViewById(R.id.iv_detail_back);
            this.f75500b = (TextView) findViewById(R.id.tv_empty);
            this.f75502d = (RecyclerView) findViewById(R.id.permission_list);
            this.f75501c = (LinearLayout) findViewById(R.id.ll_download);
            if (this.f75505g.isEmpty()) {
                this.f75502d.setVisibility(8);
                this.f75500b.setVisibility(0);
            } else {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(1);
                this.f75502d.setLayoutManager(linearLayoutManager);
                this.f75502d.setAdapter(new c(this, null));
            }
            this.f75499a.setOnClickListener(new a(this));
            this.f75501c.setOnClickListener(new b(this));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.p.a.d.b.e.b.c("lp_app_detail_click_close", this.f75504f);
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
                c.p.a.e.a.d.q(this);
            }
        }
    }

    public static void a(Activity activity, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65538, null, activity, j2) == null) {
            Intent intent = new Intent(activity, AppDetailInfoActivity.class);
            intent.putExtra("app_info_id", j2);
            activity.startActivity(intent);
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            this.f75503e = getIntent().getLongExtra("app_info_id", 0L);
            c.C1524c a2 = com.ss.android.downloadlib.addownload.compliance.c.a().a(this.f75503e);
            if (a2 == null) {
                return false;
            }
            this.f75504f = a2.f34491b;
            this.f75505g = a2.f34496g;
            return true;
        }
        return invokeV.booleanValue;
    }
}
