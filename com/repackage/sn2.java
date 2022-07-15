package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes7.dex */
public class sn2 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public ArrayList<MediaModel> b;
    public eo2 c;
    public int d;
    public int e;
    public FrameLayout.LayoutParams f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn2 a;

        public a(sn2 sn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn2 a;

        public b(sn2 sn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn2 a;

        public c(sn2 sn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn2Var;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.u();
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements bo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn2 a;

        public d(sn2 sn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn2Var;
        }

        @Override // com.repackage.bo2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                yn2.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", xn2.e);
                bundle.putString("swanAppId", xn2.f);
                bundle.putParcelableArrayList("mediaModels", yn2.e());
                bundle.putString("swanTmpPath", xn2.j);
                xn2.g(this.a.a, bundle);
            }
        }

        @Override // com.repackage.bo2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn2 a;

        public e(sn2 sn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn2Var;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.t();
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements bo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn2 a;

        public f(sn2 sn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn2Var;
        }

        @Override // com.repackage.bo2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                yn2.i(vn2.c(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", xn2.e);
                bundle.putString("swanAppId", xn2.f);
                bundle.putParcelableArrayList("mediaModels", yn2.e());
                bundle.putString("swanTmpPath", xn2.j);
                xn2.g(this.a.a, bundle);
            }
        }

        @Override // com.repackage.bo2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaModel a;
        public final /* synthetic */ j b;
        public final /* synthetic */ sn2 c;

        public g(sn2 sn2Var, MediaModel mediaModel, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var, mediaModel, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sn2Var;
            this.a = mediaModel;
            this.b = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.l(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ sn2 c;

        public h(sn2 sn2Var, MediaModel mediaModel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var, mediaModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sn2Var;
            this.a = mediaModel;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoModel a;
        public final /* synthetic */ MediaModel b;
        public final /* synthetic */ int c;
        public final /* synthetic */ sn2 d;

        public i(sn2 sn2Var, VideoModel videoModel, MediaModel mediaModel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var, videoModel, mediaModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sn2Var;
            this.a = videoModel;
            this.b = mediaModel;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.d.s(this.a.getPath()) && !this.d.n(this.a.getDuration())) {
                this.d.j(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;
        public ImageView b;
        public TextView c;
        public ImageView d;
        public View e;
        public View f;
        public TextView g;
        public View h;

        public j(sn2 sn2Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn2Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09022d);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09022f);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090231);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f090232);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090230);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090234);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090233);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09022e);
        }
    }

    public sn2(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = new ArrayList<>();
        int o = yd3.o(this.a);
        int n = yd3.n(this.a);
        this.d = o / 4;
        this.e = n / 4;
        this.f = new FrameLayout.LayoutParams((o - yd3.f(this.a, 10.0f)) / 4, (o - yd3.f(this.a, 10.0f)) / 4);
    }

    public final void A(j jVar, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jVar, view2) == null) {
            Resources resources = this.a.getResources();
            view2.setBackgroundColor(-1);
            jVar.a.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060a6b));
            jVar.c.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a76));
            jVar.h.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0810e9));
            jVar.g.setTextColor(-1);
            jVar.b.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060a79));
            jVar.a.setLayoutParams(this.f);
            jVar.b.setLayoutParams(this.f);
            jVar.b.setVisibility(8);
            jVar.c.setVisibility(8);
            jVar.f.setVisibility(8);
            jVar.h.setVisibility(8);
            jVar.f.setVisibility(0);
            jVar.d.setImageResource(R.drawable.obfuscated_res_0x7f0810f7);
            jVar.h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.h.getLayoutParams();
            layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706c3);
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706be);
            jVar.h.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? xn2.h ? this.b.size() + 1 : this.b.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (xn2.h) {
                if (i2 == 0) {
                    return null;
                }
                return this.b.get(i2 - 1);
            }
            return this.b.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (xn2.h && i2 == 0) ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view2, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07d2, (ViewGroup) null, false);
                r(inflate);
                return inflate;
            }
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07d8, (ViewGroup) null);
                jVar = new j(this, view2);
                view2.setTag(jVar);
            } else {
                jVar = (j) view2.getTag();
            }
            A(jVar, view2);
            MediaModel mediaModel = (MediaModel) getItem(i2);
            if (mediaModel == null) {
                return view2;
            }
            y(mediaModel.getPath(), jVar);
            v(mediaModel, jVar, i2);
            w(mediaModel, jVar, i2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public final void j(MediaModel mediaModel, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, mediaModel, i2) == null) || xn2.f(xn2.d, mediaModel)) {
            return;
        }
        if (xn2.h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", xn2.e);
        bundle.putString("swanAppId", xn2.f);
        bundle.putString("mode", xn2.d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        xn2.k(this.a, bundle);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (yn2.d() >= xn2.c) {
                xn2.j(xn2.d);
            } else if (vd3.c() < 52428800) {
                zz2.g(AppRuntime.getAppContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f129c)).G();
            } else {
                p(this.a);
            }
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, mediaModel, jVar) == null) {
            int d2 = yn2.d();
            if (!yn2.f(mediaModel)) {
                if (d2 >= xn2.c) {
                    xn2.j(xn2.d);
                    return;
                } else if (d2 > 0 && TextUtils.equals(xn2.d, "single") && !TextUtils.equals(yn2.b(), mediaModel.getType())) {
                    zz2.f(this.a, R.string.obfuscated_res_0x7f0f12a4).G();
                    return;
                } else if (mediaModel.getSize() <= 52428800 || !TextUtils.equals(mediaModel.getType(), "image")) {
                    jVar.d.setImageResource(R.drawable.obfuscated_res_0x7f0810f5);
                    jVar.c.setVisibility(0);
                    jVar.c.setText(String.valueOf(yn2.c(mediaModel) + 1));
                    yn2.i(mediaModel);
                    jVar.e.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010130));
                    eo2 eo2Var = this.c;
                    if (eo2Var != null) {
                        eo2Var.a(d2);
                    }
                    notifyDataSetChanged();
                    return;
                } else {
                    zz2.f(this.a, R.string.obfuscated_res_0x7f0f12a3).G();
                    return;
                }
            }
            yn2.h(mediaModel);
            jVar.d.setImageResource(R.drawable.obfuscated_res_0x7f0810f7);
            jVar.c.setVisibility(8);
            eo2 eo2Var2 = this.c;
            if (eo2Var2 != null) {
                eo2Var2.a(d2);
            }
            notifyDataSetChanged();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (yn2.d() >= xn2.c) {
                xn2.j(xn2.d);
            } else {
                q(this.a);
            }
        }
    }

    public final boolean n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            if (j2 < 3000) {
                zz2.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f12aa)).G();
                return true;
            } else if (j2 > 300000) {
                zz2.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f12a9)).G();
                return true;
            } else {
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public final String o(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
            long j3 = j2 / 1000;
            long j4 = j3 / 3600;
            long j5 = j3 % 3600;
            String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j5 / 60));
            String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j5 % 60));
            return j4 == 0 ? this.a.getString(R.string.obfuscated_res_0x7f0f132a, new Object[]{format, format2}) : this.a.getString(R.string.obfuscated_res_0x7f0f132b, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
        }
        return (String) invokeJ.objValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            jv2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new e(this));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            jv2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new c(this));
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            view2.findViewById(R.id.obfuscated_res_0x7f090226).setLayoutParams(this.f);
            view2.setTag(null);
            view2.setClickable(true);
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090227);
            if (TextUtils.equals(xn2.b, "Image")) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0810df);
                view2.setOnClickListener(new a(this));
                return;
            }
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f0810e3);
            view2.setOnClickListener(new b(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s(String str) {
        InterceptResult invokeL;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                mediaMetadataRetriever.setDataSource(str);
                str2 = mediaMetadataRetriever.extractMetadata(12);
            } catch (Exception e3) {
                e = e3;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (wn2.a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                zz2.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f12ab)).G();
                return false;
            }
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e4) {
                    if (wn2.a) {
                        e4.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
                return TextUtils.equals(MimeTypes.VIDEO_MP4, str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals(MimeTypes.VIDEO_WEBM, str2) || TextUtils.equals("video/mkv", str2);
            }
            zz2.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f12ab)).G();
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            vn2.e(this.a, xn2.f, xn2.g, xn2.i, new f(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            vn2.f(this.a, xn2.f, new d(this));
        }
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, mediaModel, jVar, i2) == null) {
            if (yn2.f(mediaModel)) {
                jVar.d.setImageResource(R.drawable.obfuscated_res_0x7f0810f5);
                jVar.c.setVisibility(0);
                jVar.c.setText(String.valueOf(yn2.c(mediaModel) + 1));
            }
            if (xn2.f(xn2.d, mediaModel)) {
                jVar.b.setVisibility(0);
            } else {
                jVar.b.setVisibility(8);
            }
            if (!wn2.d) {
                jVar.h.setVisibility(8);
            } else if (xn2.d(mediaModel.getPath())) {
                jVar.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f12a0));
            } else if (xn2.e(mediaModel.getPath())) {
                jVar.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f12a1));
            } else {
                jVar.h.setVisibility(8);
            }
            jVar.f.setOnClickListener(new g(this, mediaModel, jVar));
            jVar.a.setOnClickListener(new h(this, mediaModel, i2));
        }
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048596, this, mediaModel, jVar, i2) == null) && (mediaModel instanceof VideoModel)) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.h.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706bd);
            } else {
                layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706c1);
            }
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706be);
            jVar.h.setLayoutParams(layoutParams);
            jVar.g.setText(o(videoModel.getDuration()));
            jVar.a.setOnClickListener(new i(this, videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.b.size() > 0) {
                this.b.clear();
            }
            this.b.addAll(arrayList);
            xn2.i(this.b);
            notifyDataSetChanged();
        }
    }

    public final void y(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, jVar) == null) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
            newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.d / 2.0f), (int) (this.e / 2.0f)));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.a.getController()).build();
            jVar.a.setController(build);
            DraweeHierarchy hierarchy = build.getHierarchy();
            if (hierarchy instanceof GenericDraweeHierarchy) {
                oj2.C().c((GenericDraweeHierarchy) hierarchy, false);
            }
        }
    }

    public void z(eo2 eo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eo2Var) == null) {
            this.c = eo2Var;
        }
    }
}
