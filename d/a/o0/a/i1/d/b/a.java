package d.a.o0.a.i1.d.b;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.sina.weibo.sdk.utils.FileUtils;
import d.a.o0.a.v2.k0;
import d.a.o0.a.v2.n0;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f45957e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f45958f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.a.i1.d.d.e f45959g;

    /* renamed from: h  reason: collision with root package name */
    public int f45960h;

    /* renamed from: i  reason: collision with root package name */
    public int f45961i;
    public FrameLayout.LayoutParams j;

    /* renamed from: d.a.o0.a.i1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC0787a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f45962e;

        public View$OnClickListenerC0787a(a aVar) {
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
            this.f45962e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45962e.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f45963e;

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
            this.f45963e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45963e.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45964a;

        public c(a aVar) {
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
            this.f45964a = aVar;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f45964a.u();
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45965a;

        public d(a aVar) {
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
            this.f45965a = aVar;
        }

        @Override // d.a.o0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                d.a.o0.a.i1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.a.o0.a.i1.d.c.d.f46007e);
                bundle.putString("swanAppId", d.a.o0.a.i1.d.c.d.f46008f);
                bundle.putParcelableArrayList("mediaModels", d.a.o0.a.i1.d.c.e.e());
                bundle.putString("swanTmpPath", d.a.o0.a.i1.d.c.d.j);
                d.a.o0.a.i1.d.c.d.g(this.f45965a.f45957e, bundle);
            }
        }

        @Override // d.a.o0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45966a;

        public e(a aVar) {
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
            this.f45966a = aVar;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f45966a.t();
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.o0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45967a;

        public f(a aVar) {
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
            this.f45967a = aVar;
        }

        @Override // d.a.o0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                d.a.o0.a.i1.d.c.e.i(d.a.o0.a.i1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.a.o0.a.i1.d.c.d.f46007e);
                bundle.putString("swanAppId", d.a.o0.a.i1.d.c.d.f46008f);
                bundle.putParcelableArrayList("mediaModels", d.a.o0.a.i1.d.c.e.e());
                bundle.putString("swanTmpPath", d.a.o0.a.i1.d.c.d.j);
                d.a.o0.a.i1.d.c.d.g(this.f45967a.f45957e, bundle);
            }
        }

        @Override // d.a.o0.a.i1.d.d.b
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f45968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f45969f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f45970g;

        public g(a aVar, MediaModel mediaModel, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mediaModel, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45970g = aVar;
            this.f45968e = mediaModel;
            this.f45969f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45970g.l(this.f45968e, this.f45969f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f45971e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45972f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f45973g;

        public h(a aVar, MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mediaModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45973g = aVar;
            this.f45971e = mediaModel;
            this.f45972f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45973g.j(this.f45971e, this.f45972f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f45974e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f45975f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45976g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f45977h;

        public i(a aVar, VideoModel videoModel, MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, videoModel, mediaModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45977h = aVar;
            this.f45974e = videoModel;
            this.f45975f = mediaModel;
            this.f45976g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f45977h.s(this.f45974e.getPath()) && !this.f45977h.n(this.f45974e.getDuration())) {
                this.f45977h.j(this.f45975f, this.f45976g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f45978a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f45979b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f45980c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f45981d;

        /* renamed from: e  reason: collision with root package name */
        public View f45982e;

        /* renamed from: f  reason: collision with root package name */
        public View f45983f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f45984g;

        /* renamed from: h  reason: collision with root package name */
        public View f45985h;

        public j(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45978a = (SimpleDraweeView) view.findViewById(d.a.o0.a.f.album_item_img);
            this.f45981d = (ImageView) view.findViewById(d.a.o0.a.f.album_item_select_checkbox);
            this.f45980c = (TextView) view.findViewById(d.a.o0.a.f.album_item_select_number);
            this.f45983f = view.findViewById(d.a.o0.a.f.album_item_selected_check);
            this.f45982e = view.findViewById(d.a.o0.a.f.album_item_select_circle_view);
            this.f45979b = (ImageView) view.findViewById(d.a.o0.a.f.album_item_unable_shadow);
            this.f45985h = view.findViewById(d.a.o0.a.f.album_item_tip_bg);
            this.f45984g = (TextView) view.findViewById(d.a.o0.a.f.album_item_right_bottom_tip);
        }
    }

    public a(Activity activity) {
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
        this.f45957e = activity;
        this.f45958f = new ArrayList<>();
        int o = n0.o(this.f45957e);
        int n = n0.n(this.f45957e);
        this.f45960h = o / 4;
        this.f45961i = n / 4;
        this.j = new FrameLayout.LayoutParams((o - n0.f(this.f45957e, 10.0f)) / 4, (o - n0.f(this.f45957e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jVar, view) == null) {
            Resources resources = this.f45957e.getResources();
            view.setBackgroundColor(-1);
            jVar.f45978a.setBackgroundColor(resources.getColor(d.a.o0.a.c.swanapp_album_item_select_bg));
            jVar.f45980c.setTextColor(resources.getColor(d.a.o0.a.c.swanapp_album_select_number_color));
            jVar.f45985h.setBackground(resources.getDrawable(d.a.o0.a.e.swanapp_album_item_duration_bg));
            jVar.f45984g.setTextColor(-1);
            jVar.f45979b.setBackgroundColor(resources.getColor(d.a.o0.a.c.swanapp_album_unenable_shadow_color));
            jVar.f45978a.setLayoutParams(this.j);
            jVar.f45979b.setLayoutParams(this.j);
            jVar.f45979b.setVisibility(8);
            jVar.f45980c.setVisibility(8);
            jVar.f45983f.setVisibility(8);
            jVar.f45985h.setVisibility(8);
            jVar.f45983f.setVisibility(0);
            jVar.f45981d.setImageResource(d.a.o0.a.e.swanapp_album_unselect_thumb_icon);
            jVar.f45985h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f45985h.getLayoutParams();
            layoutParams.width = this.f45957e.getResources().getDimensionPixelSize(d.a.o0.a.d.swanapp_album_item_tip_width);
            layoutParams.height = this.f45957e.getResources().getDimensionPixelSize(d.a.o0.a.d.swanapp_album_item_time_height);
            jVar.f45985h.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.o0.a.i1.d.c.d.f46010h ? this.f45958f.size() + 1 : this.f45958f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (d.a.o0.a.i1.d.c.d.f46010h) {
                if (i2 == 0) {
                    return null;
                }
                return this.f45958f.get(i2 - 1);
            }
            return this.f45958f.get(i2);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (d.a.o0.a.i1.d.c.d.f46010h && i2 == 0) ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                View inflate = LayoutInflater.from(this.f45957e).inflate(d.a.o0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
                r(inflate);
                return inflate;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f45957e).inflate(d.a.o0.a.g.swanapp_album_select_item, (ViewGroup) null);
                jVar = new j(this, view);
                view.setTag(jVar);
            } else {
                jVar = (j) view.getTag();
            }
            A(jVar, view);
            MediaModel mediaModel = (MediaModel) getItem(i2);
            if (mediaModel == null) {
                return view;
            }
            y(mediaModel.getPath(), jVar);
            v(mediaModel, jVar, i2);
            w(mediaModel, jVar, i2);
            return view;
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
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, mediaModel, i2) == null) || d.a.o0.a.i1.d.c.d.f(d.a.o0.a.i1.d.c.d.f46006d, mediaModel)) {
            return;
        }
        if (d.a.o0.a.i1.d.c.d.f46010h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", d.a.o0.a.i1.d.c.d.f46007e);
        bundle.putString("swanAppId", d.a.o0.a.i1.d.c.d.f46008f);
        bundle.putString("mode", d.a.o0.a.i1.d.c.d.f46006d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        d.a.o0.a.i1.d.c.d.k(this.f45957e, bundle);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (d.a.o0.a.i1.d.c.e.d() >= d.a.o0.a.i1.d.c.d.f46005c) {
                d.a.o0.a.i1.d.c.d.j(d.a.o0.a.i1.d.c.d.f46006d);
            } else if (k0.c() < 52428800) {
                d.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f45957e.getResources().getString(d.a.o0.a.h.swanapp_album_camera_no_storage)).F();
            } else {
                p(this.f45957e);
            }
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, mediaModel, jVar) == null) {
            int d2 = d.a.o0.a.i1.d.c.e.d();
            if (!d.a.o0.a.i1.d.c.e.f(mediaModel)) {
                if (d2 >= d.a.o0.a.i1.d.c.d.f46005c) {
                    d.a.o0.a.i1.d.c.d.j(d.a.o0.a.i1.d.c.d.f46006d);
                    return;
                } else if (d2 > 0 && TextUtils.equals(d.a.o0.a.i1.d.c.d.f46006d, "single") && !TextUtils.equals(d.a.o0.a.i1.d.c.e.b(), mediaModel.getType())) {
                    d.a.o0.a.z1.b.f.e.f(this.f45957e, d.a.o0.a.h.swanapp_album_select_single).F();
                    return;
                } else if (mediaModel.getSize() <= 52428800 || !TextUtils.equals(mediaModel.getType(), "image")) {
                    jVar.f45981d.setImageResource(d.a.o0.a.e.swanapp_album_select_icon_bg);
                    jVar.f45980c.setVisibility(0);
                    jVar.f45980c.setText(String.valueOf(d.a.o0.a.i1.d.c.e.c(mediaModel) + 1));
                    d.a.o0.a.i1.d.c.e.i(mediaModel);
                    jVar.f45982e.startAnimation(AnimationUtils.loadAnimation(this.f45957e, d.a.o0.a.a.swanapp_album_checkshake));
                    d.a.o0.a.i1.d.d.e eVar = this.f45959g;
                    if (eVar != null) {
                        eVar.a(d2);
                    }
                    notifyDataSetChanged();
                    return;
                } else {
                    d.a.o0.a.z1.b.f.e.f(this.f45957e, d.a.o0.a.h.swanapp_album_photo_too_big).F();
                    return;
                }
            }
            d.a.o0.a.i1.d.c.e.h(mediaModel);
            jVar.f45981d.setImageResource(d.a.o0.a.e.swanapp_album_unselect_thumb_icon);
            jVar.f45980c.setVisibility(8);
            d.a.o0.a.i1.d.d.e eVar2 = this.f45959g;
            if (eVar2 != null) {
                eVar2.a(d2);
            }
            notifyDataSetChanged();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (d.a.o0.a.i1.d.c.e.d() >= d.a.o0.a.i1.d.c.d.f46005c) {
                d.a.o0.a.i1.d.c.d.j(d.a.o0.a.i1.d.c.d.f46006d);
            } else {
                q(this.f45957e);
            }
        }
    }

    public final boolean n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            if (j2 < 3000) {
                d.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f45957e.getString(d.a.o0.a.h.swanapp_album_video_duration_min)).F();
                return true;
            } else if (j2 > 300000) {
                d.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f45957e.getString(d.a.o0.a.h.swanapp_album_video_duration_max)).F();
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
            return j4 == 0 ? this.f45957e.getString(d.a.o0.a.h.swanapp_video_duration, new Object[]{format, format2}) : this.f45957e.getString(d.a.o0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
        }
        return (String) invokeJ.objValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            d.a.o0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e(this));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            d.a.o0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c(this));
        }
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            view.findViewById(d.a.o0.a.f.album_camera_enter).setLayoutParams(this.j);
            view.setTag(null);
            view.setClickable(true);
            ImageView imageView = (ImageView) view.findViewById(d.a.o0.a.f.album_camera_icon);
            if (TextUtils.equals(d.a.o0.a.i1.d.c.d.f46004b, "Image")) {
                imageView.setImageResource(d.a.o0.a.e.swanapp_album_camera_item_selector);
                view.setOnClickListener(new View$OnClickListenerC0787a(this));
                return;
            }
            imageView.setImageResource(d.a.o0.a.e.swanapp_album_camera_video_selector);
            view.setOnClickListener(new b(this));
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
                if (d.a.o0.a.i1.d.c.c.f45999a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                d.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f45957e.getString(d.a.o0.a.h.swanapp_album_video_format)).F();
                return false;
            }
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.close();
                } catch (Exception e4) {
                    if (d.a.o0.a.i1.d.c.c.f45999a) {
                        e4.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
                return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
            }
            d.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f45957e.getString(d.a.o0.a.h.swanapp_album_video_format)).F();
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            d.a.o0.a.i1.d.c.b.e(this.f45957e, d.a.o0.a.i1.d.c.d.f46008f, d.a.o0.a.i1.d.c.d.f46009g, d.a.o0.a.i1.d.c.d.f46011i, new f(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            d.a.o0.a.i1.d.c.b.f(this.f45957e, d.a.o0.a.i1.d.c.d.f46008f, new d(this));
        }
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, mediaModel, jVar, i2) == null) {
            if (d.a.o0.a.i1.d.c.e.f(mediaModel)) {
                jVar.f45981d.setImageResource(d.a.o0.a.e.swanapp_album_select_icon_bg);
                jVar.f45980c.setVisibility(0);
                jVar.f45980c.setText(String.valueOf(d.a.o0.a.i1.d.c.e.c(mediaModel) + 1));
            }
            if (d.a.o0.a.i1.d.c.d.f(d.a.o0.a.i1.d.c.d.f46006d, mediaModel)) {
                jVar.f45979b.setVisibility(0);
            } else {
                jVar.f45979b.setVisibility(8);
            }
            if (!d.a.o0.a.i1.d.c.c.f46002d) {
                jVar.f45985h.setVisibility(8);
            } else if (d.a.o0.a.i1.d.c.d.d(mediaModel.getPath())) {
                jVar.f45984g.setText(this.f45957e.getString(d.a.o0.a.h.swanapp_album_gif_photo));
            } else if (d.a.o0.a.i1.d.c.d.e(mediaModel.getPath())) {
                jVar.f45984g.setText(this.f45957e.getString(d.a.o0.a.h.swanapp_album_large_photo));
            } else {
                jVar.f45985h.setVisibility(8);
            }
            jVar.f45983f.setOnClickListener(new g(this, mediaModel, jVar));
            jVar.f45978a.setOnClickListener(new h(this, mediaModel, i2));
        }
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048596, this, mediaModel, jVar, i2) == null) && (mediaModel instanceof VideoModel)) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f45985h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f45985h.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.f45957e.getResources().getDimensionPixelSize(d.a.o0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f45957e.getResources().getDimensionPixelSize(d.a.o0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f45957e.getResources().getDimensionPixelSize(d.a.o0.a.d.swanapp_album_item_time_height);
            jVar.f45985h.setLayoutParams(layoutParams);
            jVar.f45984g.setText(o(videoModel.getDuration()));
            jVar.f45978a.setOnClickListener(new i(this, videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.f45958f.size() > 0) {
                this.f45958f.clear();
            }
            this.f45958f.addAll(arrayList);
            d.a.o0.a.i1.d.c.d.i(this.f45958f);
            notifyDataSetChanged();
        }
    }

    public final void y(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, jVar) == null) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
            newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f45960h / 2.0f), (int) (this.f45961i / 2.0f)));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.f45978a.getController()).build();
            jVar.f45978a.setController(build);
            DraweeHierarchy hierarchy = build.getHierarchy();
            if (hierarchy instanceof GenericDraweeHierarchy) {
                d.a.o0.a.c1.a.y().c((GenericDraweeHierarchy) hierarchy, false);
            }
        }
    }

    public void z(d.a.o0.a.i1.d.d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.f45959g = eVar;
        }
    }
}
