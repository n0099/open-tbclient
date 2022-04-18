package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.sticker.OnChangeStickerListener;
import com.repackage.k86;
import java.io.File;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c86 implements z76, PreViewPickCoverView.c, ty8, OnChangeStickerListener, a86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public VlogEditManager b;
    public MultiMediaDataSourceViewAdapter c;
    public TbGLMediaPreviewView d;
    public PreViewPickCoverView e;
    public float f;
    public float g;
    public TbMultiMediaData h;
    public List<MultiMediaData> i;
    public ps8 j;
    public MultiMediaData k;
    public MultiMediaData l;
    public TextWordsEntity m;
    public ArrayList<IEffectProcessor> n;
    public ArrayList<IMediaRenderer> o;
    public b86 p;
    public a86 q;
    @Nullable
    public List<MultiMediaData> r;

    /* loaded from: classes5.dex */
    public class a implements MultiMediaDataSourceViewAdapter.OnMultiMediaDataTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c86 c86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.OnMultiMediaDataTextureListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ c86 b;

        public b(c86 c86Var, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c86Var, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c86Var;
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.j.c(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c86 a;

        public c(c86 c86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c86Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c86 a;

        public d(c86 c86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c86Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Buffer captureVideoCover;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (captureVideoCover = this.a.b.captureVideoCover(this.a.b.getCurrentIndex(), this.a.b.getCurrentPlayTime(), this.a.d.getWidth(), this.a.d.getHeight())) == null) {
                return;
            }
            c86 c86Var = this.a;
            c86Var.E(captureVideoCover, c86Var.d.getWidth(), this.a.d.getHeight());
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c86 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ e b;

            public a(e eVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.e == null) {
                    return;
                }
                this.b.a.e.s(this.a);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.e.g();
                }
            }
        }

        public e(c86 c86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c86Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null && this.a.b.isPaused()) {
                if (this.a.l != null) {
                    sc9.a().post(new a(this, BitmapFactory.decodeFile(this.a.l.path)));
                    return;
                }
                sc9.a().post(new b(this));
            }
        }
    }

    public c86(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, PreViewPickCoverView preViewPickCoverView, TbMultiMediaData tbMultiMediaData, boolean z) {
        File CreateFileIfNotFound;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, preViewPickCoverView, tbMultiMediaData, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.d = tbGLMediaPreviewView;
        this.e = preViewPickCoverView;
        this.i = new ArrayList();
        this.h = tbMultiMediaData;
        try {
            TextWordsEntity parse = TextWordsEntity.parse(new JSONObject("{\"style\":[{\"id\":\"1\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328775756\\/1.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"shadow_infos\":[{\"color\":\"000000\",\"alpha\":\"0.4\",\"width\":\"1\",\"offset_x\":\"0\",\"offset_y\":\"2\",\"blur\":\"4\"}],\"type\":1},{\"id\":\"17\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328785140\\/2.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"000000\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":2},{\"id\":\"18\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328796132\\/3.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"E44A41\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"226EEA\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":3},{\"id\":\"4\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328806597\\/4.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"000000\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599034626568\\/%E6%A0%B7%E5%BC%8F%E4%B8%80%20copy%403x.png\",\"left\":24,\"right\":51,\"top\":111,\"bottom\":40,\"stretchableX\":[{\"start\":160,\"stop\":230}],\"stretchableY\":[{\"start\":100,\"stop\":170}],\"width\":228,\"imageType\":3},\"type\":3},{\"id\":\"5\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328817830\\/5.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"393939\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599037658846\\/%E6%A0%B7%E5%BC%8F%E4%BA%8C%20copy%403x.png\",\"left\":64,\"right\":118,\"top\":62,\"bottom\":61,\"stretchableX\":[{\"start\":120,\"stop\":220}],\"stretchableY\":[{\"start\":64,\"stop\":67}],\"width\":423,\"imageType\":3},\"type\":3},{\"id\":\"6\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328828185\\/6.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"393939\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599037845877\\/%E6%A0%B7%E5%BC%8F%E4%B8%89%20copy%403x.png\",\"left\":54,\"right\":23,\"top\":41,\"bottom\":84,\"stretchableX\":[{\"start\":250,\"stop\":300}],\"stretchableY\":[{\"start\":50,\"stop\":100}],\"width\":366,\"imageType\":3},\"type\":3},{\"id\":\"2\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328839826\\/7.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"F6B700\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"000000\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":3},{\"id\":\"19\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328850600\\/8.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"000000\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"000000\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":2},{\"id\":\"20\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328861049\\/9.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"F5B47A\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"E44A41\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":3},{\"id\":\"7\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328878943\\/10.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"1C2045\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599046528732\\/%E6%A0%B7%E5%BC%8F%E5%9B%9B%20copy%403x.png\",\"left\":61,\"right\":61,\"top\":69,\"bottom\":52,\"stretchableX\":[{\"start\":80,\"stop\":180}],\"stretchableY\":[{\"start\":60,\"stop\":110}],\"width\":399,\"imageType\":3},\"type\":3},{\"id\":\"8\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328889391\\/11.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"D21D1D\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038226204\\/%E6%A0%B7%E5%BC%8F%E4%BA%94%20copy%403x.png\",\"left\":42,\"right\":42,\"top\":37,\"bottom\":37,\"stretchableX\":[{\"start\":75,\"stop\":175}],\"stretchableY\":[{\"start\":45,\"stop\":95}],\"width\":366,\"imageType\":3},\"type\":3},{\"id\":\"9\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328899162\\/12.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038375610\\/%E6%A0%B7%E5%BC%8F%E5%85%AD%20copy%202%403x.png\",\"left\":42,\"right\":42,\"top\":36,\"bottom\":35,\"stretchableX\":[{\"start\":90,\"stop\":110}],\"stretchableY\":[{\"start\":45,\"stop\":95}],\"width\":369,\"imageType\":3},\"type\":3},{\"id\":\"10\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328911294\\/13.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"8B82F2\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038418173\\/%E6%A0%B7%E5%BC%8F%E4%B8%83%20copy%403x.png\",\"left\":84,\"right\":86,\"top\":64,\"bottom\":73,\"stretchableX\":[{\"start\":76,\"stop\":80}],\"stretchableY\":[{\"start\":85,\"stop\":128}],\"width\":330,\"imageType\":3},\"type\":3},{\"id\":\"3\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328921311\\/14.png\",\"text_type\":\"2\",\"text_infos\":[{\"color\":\"FFBBD4\",\"alpha\":\"1\"},{\"color\":\"5FBDFF\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"D53D70\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":4},{\"id\":\"11\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328932445\\/15.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"000000\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038574480\\/%E6%A0%B7%E5%BC%8F%E5%85%AB%20copy%202%403x.png\",\"left\":84,\"right\":86,\"top\":108,\"bottom\":72,\"stretchableX\":[{\"start\":170,\"stop\":185}],\"stretchableY\":[{\"start\":125,\"stop\":145}],\"width\":300,\"imageType\":3},\"type\":3},{\"id\":\"21\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328943567\\/16.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FF4D86\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328646623\\/%E8%A1%A5%E5%85%85%E5%88%87%E5%9B%BE%403x.png\",\"left\":44,\"right\":12,\"top\":167,\"bottom\":52,\"stretchableX\":[{\"start\":176,\"stop\":178}],\"stretchableY\":[{\"start\":160,\"stop\":200}],\"width\":300,\"imageType\":3},\"type\":3},{\"id\":\"12\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328955001\\/17.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FF739F\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038680352\\/%E6%A0%B7%E5%BC%8F%E4%B9%9D%20copy%202%403x.png\",\"left\":47,\"right\":60,\"top\":33,\"bottom\":75,\"stretchableX\":[{\"start\":60,\"stop\":230}],\"stretchableY\":[{\"start\":62,\"stop\":124}],\"width\":378,\"imageType\":3},\"type\":3},{\"id\":\"13\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328971847\\/18.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038716716\\/%E6%A0%B7%E5%BC%8F%E5%8D%81%20copy%403x.png\",\"left\":25,\"right\":46,\"top\":27,\"bottom\":52,\"stretchableX\":[{\"start\":90,\"stop\":120}],\"stretchableY\":[{\"start\":72,\"stop\":80}],\"width\":336,\"imageType\":3},\"type\":3},{\"id\":\"14\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328981395\\/19.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038844265\\/%E6%A0%B7%E5%BC%8F%E5%8D%81%E4%B8%80%20copy%202%403x.png\",\"left\":38,\"right\":30,\"top\":67,\"bottom\":24,\"stretchableX\":[{\"start\":192,\"stop\":279}],\"stretchableY\":[{\"start\":76,\"stop\":159}],\"width\":333,\"imageType\":3},\"type\":3},{\"id\":\"15\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328992077\\/20.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFCDCD\",\"alpha\":\"1\"}],\"shadow_infos\":[{\"color\":\"FF2626\",\"alpha\":\"0.8\",\"width\":\"1\",\"offset_x\":\"0\",\"offset_y\":\"0\",\"blur\":\"9\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599039053238\\/%E6%A0%B7%E5%BC%8F%E5%8D%81%E4%BA%8C%20copy%202%403x.png\",\"left\":58,\"right\":58,\"top\":45,\"bottom\":49,\"stretchableX\":[{\"start\":130,\"stop\":200}],\"stretchableY\":[{\"start\":68,\"stop\":90}],\"width\":399,\"imageType\":3},\"type\":5},{\"id\":\"16\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600329002255\\/21.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"shadow_infos\":[{\"color\":\"EA26FF\",\"alpha\":\"1\",\"width\":\"1\",\"offset_x\":\"0\",\"offset_y\":\"0\",\"blur\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599039871892\\/%E6%A0%B7%E5%BC%8F%E5%8D%81%E4%B8%89%20copy%202%403x.png\",\"left\":46,\"right\":38,\"top\":65,\"bottom\":89,\"stretchableX\":[{\"start\":67,\"stop\":175}],\"stretchableY\":[{\"start\":55,\"stop\":154}],\"width\":291,\"imageType\":3},\"type\":5}],\"font\":[{\"id\":1,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E9%BB%98%E8%AE%A4%403x.png\",\"download_url\":\"\",\"is_default\":1},{\"id\":2,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E7%B2%97%E9%BB%91%E5%AE%8B%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/FZCHSJW.TTF\",\"is_default\":0},{\"id\":3,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E6%B8%85%E5%88%BB%E6%9C%AC%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/FZQKBYSJW.TTF\",\"is_default\":0},{\"id\":4,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E7%88%BD%E8%B6%A3%E4%BD%93%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/FZShuangQTJW.TTF\",\"is_default\":0},{\"id\":5,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E6%B3%A1%E6%B3%A1%E4%BD%93%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/FZSJ-HLPPJW.TTF\",\"is_default\":0},{\"id\":6,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E5%90%8E%E7%8E%B0%E4%BB%A3%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-4\\/1587628115391\\/WenYue-HouXianDaiTi-W4-75-J.otf\",\"is_default\":0},{\"id\":7,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E6%96%B0%E9%9D%92%E5%B9%B4%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-4\\/1587628115881\\/WenYue-XinQingNianTi-W8-J.otf\",\"is_default\":0}],\"color\":[{\"color\":\"FFFFFF\",\"alpha\":1},{\"color\":\"CCCCCC\",\"alpha\":1},{\"color\":\"999999\",\"alpha\":1},{\"color\":\"666666\",\"alpha\":1},{\"color\":\"333333\",\"alpha\":1},{\"color\":\"000000\",\"alpha\":1},{\"color\":\"FFCDD2\",\"alpha\":1},{\"color\":\"FFA098\",\"alpha\":1},{\"color\":\"FF6E6E\",\"alpha\":1},{\"color\":\"FF5353\",\"alpha\":1},{\"color\":\"FE1818\",\"alpha\":1},{\"color\":\"B71C1C\",\"alpha\":1},{\"color\":\"FFF9C9\",\"alpha\":1},{\"color\":\"FEF589\",\"alpha\":1},{\"color\":\"FEDE00\",\"alpha\":1},{\"color\":\"FA864C\",\"alpha\":1},{\"color\":\"FF7B39\",\"alpha\":1},{\"color\":\"F45100\",\"alpha\":1},{\"color\":\"FED9E8\",\"alpha\":1},{\"color\":\"FFAAC1\",\"alpha\":1},{\"color\":\"FF619D\",\"alpha\":1},{\"color\":\"FE287F\",\"alpha\":1},{\"color\":\"F1166C\",\"alpha\":1},{\"color\":\"941044\",\"alpha\":1},{\"color\":\"C5C4FF\",\"alpha\":1},{\"color\":\"8E80E5\",\"alpha\":1},{\"color\":\"B57DFF\",\"alpha\":1},{\"color\":\"9055FE\",\"alpha\":1},{\"color\":\"6D1FFF\",\"alpha\":1},{\"color\":\"42369A\",\"alpha\":1},{\"color\":\"BEE4FF\",\"alpha\":1},{\"color\":\"91C7FF\",\"alpha\":1},{\"color\":\"469DF3\",\"alpha\":1},{\"color\":\"047BFE\",\"alpha\":1},{\"color\":\"0024FF\",\"alpha\":1},{\"color\":\"1D4AA1\",\"alpha\":1},{\"color\":\"D4F1E9\",\"alpha\":1},{\"color\":\"B9F4CA\",\"alpha\":1},{\"color\":\"69F0AE\",\"alpha\":1},{\"color\":\"00E676\",\"alpha\":1},{\"color\":\"00FF54\",\"alpha\":1},{\"color\":\"18893E\",\"alpha\":1}]}"));
            this.m = parse;
            if (!ListUtils.isEmpty(parse.mCoverStyleList)) {
                for (TextWordsEntity.TextStyleEntity textStyleEntity : this.m.mCoverStyleList) {
                    if (textStyleEntity != null && textStyleEntity.mBackgroudInfoEntity != null && (CreateFileIfNotFound = FileHelper.CreateFileIfNotFound(".cover_style")) != null) {
                        textStyleEntity.mBackgroudInfoEntity.mLocalParentFile = CreateFileIfNotFound.getAbsolutePath();
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f = tbMultiMediaData.videoRatio;
        this.p = new b86(z);
    }

    public final void A(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, multiMediaData) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.deleteCoverStickerData(multiMediaData);
            }
            ps8 ps8Var = this.j;
            if (ps8Var != null) {
                ps8Var.b(multiMediaData);
            }
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            D();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.b == null) {
            return;
        }
        int j = rc9.j(R.dimen.tbds32);
        if (this.d.getWidth() > this.d.getHeight()) {
            j = rc9.j(R.dimen.tbds28);
        }
        ms8.d().j((int) (j * 1.0f));
        ps8 ps8Var = new ps8(this.a.getPageActivity(), this.b);
        this.j = ps8Var;
        ps8Var.h("cover_sticker");
        TbGLMediaPreviewView tbGLMediaPreviewView = this.d;
        if (tbGLMediaPreviewView != null) {
            this.j.i(tbGLMediaPreviewView.getWidth(), this.d.getHeight());
        }
        TextWordsEntity textWordsEntity = this.m;
        if (textWordsEntity != null) {
            if (!ListUtils.isEmpty(textWordsEntity.mCoverFontList)) {
                this.j.f(this.m.mCoverFontList.get(0));
            }
            if (ListUtils.isEmpty(this.m.mCoverStyleList)) {
                return;
            }
            this.j.g(this.m.mCoverStyleList.get(0));
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.post(new c(this));
            this.e.setPreViewPickCoverViewListener(this);
            this.e.setOnTextWordsEditListener(this);
            this.e.setCoverEntity(this.m);
            this.e.setLastPercent(0.0f);
            this.e.r(0.0f);
            a(0.0f);
            this.e.m();
            this.e.setMultiMediaData(this.h);
            this.b.seek(0L);
        }
    }

    public final void E(Buffer buffer, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, buffer, i, i2) == null) {
            k86.a aVar = new k86.a();
            aVar.t(i);
            aVar.o(i2);
            aVar.p(true);
            aVar.n(buffer);
            aVar.r(this.f);
            VlogEditManager vlogEditManager = this.b;
            aVar.q(vlogEditManager == null ? null : vlogEditManager.getMultiMediaData(vlogEditManager.getCurrentIndex()));
            aVar.s("manual");
            k86 m = aVar.m();
            this.p.e(this);
            this.p.d(o());
            this.p.b(m, "manual");
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView.c
    public void a(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.g = f;
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView.c
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.seek(j);
            }
            this.d.queueEvent(new e(this));
        }
    }

    @Override // com.repackage.z76
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            f();
        }
    }

    @Override // com.repackage.z76
    public void d(a86 a86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a86Var) == null) {
            this.q = a86Var;
        }
    }

    @Override // com.repackage.z76
    public void e(VlogEditManager vlogEditManager, MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, vlogEditManager, multiMediaDataSourceViewAdapter) == null) {
            this.b = vlogEditManager;
            vlogEditManager.setStickerMinScale(0.5f);
            this.b.setStickerMaxScale(5.0f);
            this.c = multiMediaDataSourceViewAdapter;
            multiMediaDataSourceViewAdapter.setMultiMediaDataTextureListener(new a(this));
            this.n = new ArrayList<>();
            ArrayList<IMediaRenderer> arrayList = new ArrayList<>();
            this.o = arrayList;
            this.c.buildProcessorsAndRenderers(this.n, arrayList, true);
            this.d.setEffectProcessor(this.n);
            this.d.setMediaRenderers(this.o);
            this.c.setOnChangeStickerListener(this);
            this.c.setOnChangeCoverStickerListener(this);
            B();
        }
    }

    @Override // com.repackage.z76
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.p.c(true);
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.cancelStickerSelected();
            }
            z();
            this.d.queueEvent(new d(this));
        }
    }

    @Override // com.repackage.ty8
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView.c
    public void h(TextWordsEntity.TextStyleEntity textStyleEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, textStyleEntity) == null) {
            this.b.setUpEditLayer("cover_sticker");
            if (textStyleEntity == null) {
                return;
            }
            if (this.k == null) {
                MultiMediaData multiMediaData = new MultiMediaData();
                this.k = multiMediaData;
                multiMediaData.setExt("text", rc9.l(R.string.obfuscated_res_0x7f0f1464));
                this.i.add(this.k);
                this.j.e(-1);
            } else {
                this.j.e(0);
            }
            this.j.a(116, null, this.k, textStyleEntity, null);
        }
    }

    @Override // com.repackage.z76
    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
            this.g = f;
            this.e.r(f);
        }
    }

    @Override // com.repackage.z76
    @Nullable
    public List<MultiMediaData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    @Override // com.repackage.ty8
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.j.e(0);
            this.j.a(108, str, this.k, null, null);
        }
    }

    @Override // com.repackage.z76
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.l != null) {
                this.b.deleteMultiMediaData(0);
                this.l = null;
            }
            this.b.reset();
            i(this.g);
        }
    }

    @Override // com.repackage.z76
    public void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || this.b == null) {
            return;
        }
        this.e.l();
        if (this.l != null) {
            this.b.deleteMultiMediaData(0);
        }
        MultiMediaData multiMediaData = new MultiMediaData();
        this.l = multiMediaData;
        multiMediaData.path = str;
        multiMediaData.type = 0;
        multiMediaData.start = 0L;
        multiMediaData.end = 3000L;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.l);
        this.b.needDrawEffect(false);
        this.b.addMultiMediaData(0, arrayList);
        this.b.reset();
        this.e.s(BitmapFactory.decodeFile(str));
        this.b.seek(0L);
    }

    @Override // com.repackage.ty8
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.e.h();
        }
    }

    @Override // com.repackage.z76
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l != null : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onAutoAdjust(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onChangeSticker(int i, MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048597, this, i, multiMediaData, str) == null) {
            this.k = multiMediaData;
            this.e.h();
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onClickSticker(MultiMediaData multiMediaData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048598, this, multiMediaData, str, z) == null) {
            this.e.o(multiMediaData.getExt("text"));
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onClickStickerOutside(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.k = null;
            this.e.h();
        }
    }

    @Override // com.repackage.a86
    public void onCoverPathCallBack(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            List<MultiMediaData> list = this.r;
            if (list == null) {
                this.r = new ArrayList();
            } else {
                list.clear();
            }
            this.r.addAll(this.i);
            this.k = null;
            y();
            this.b.setUpEditLayer("");
            a86 a86Var = this.q;
            if (a86Var != null) {
                a86Var.onCoverPathCallBack(str);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onDeleteSticker(MultiMediaData multiMediaData, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{multiMediaData, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            MultiMediaData multiMediaData2 = this.k;
            if (multiMediaData2 != null) {
                multiMediaData2.setExt("text", rc9.l(R.string.obfuscated_res_0x7f0f1464));
            }
            this.k = null;
            this.e.h();
        }
    }

    @Override // com.repackage.z76
    public void onDestroy() {
        PreViewPickCoverView preViewPickCoverView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (preViewPickCoverView = this.e) == null) {
            return;
        }
        preViewPickCoverView.n();
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onEditSticker(MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, multiMediaData, str) == null) {
            this.k = multiMediaData;
            this.e.o(multiMediaData.getExt("text"));
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onStickerDataChanged(String str, MultiMediaData multiMediaData, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, str, multiMediaData, str2) == null) {
            this.k = multiMediaData;
        }
    }

    @Override // com.repackage.z76
    public float p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.g : invokeV.floatValue;
    }

    @Override // com.repackage.z76
    public void q(@Nullable List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MultiMediaData multiMediaData : list) {
            arrayList.add((MultiMediaData) multiMediaData.clone());
        }
        this.k = (MultiMediaData) arrayList.get(arrayList.size() - 1);
        this.i.addAll(arrayList);
        ps8 ps8Var = this.j;
        if (ps8Var != null) {
            ps8Var.c(arrayList);
        } else {
            this.d.post(new b(this, arrayList));
        }
    }

    @Override // com.repackage.z76
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.k = null;
            y();
            this.b.setUpEditLayer("");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            Iterator<MultiMediaData> it = this.i.iterator();
            while (it.hasNext()) {
                A(it.next());
                it.remove();
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            Iterator<MultiMediaData> it = this.i.iterator();
            while (it.hasNext()) {
                MultiMediaData next = it.next();
                if (this.j.d(next)) {
                    A(next);
                    it.remove();
                }
            }
        }
    }
}
