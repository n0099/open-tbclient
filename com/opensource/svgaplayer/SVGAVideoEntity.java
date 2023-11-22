package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.tieba.i9c;
import com.baidu.tieba.l9c;
import com.baidu.tieba.q9c;
import com.baidu.tieba.u9c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
import com.tencent.connect.share.QzonePublish;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000B\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0010\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\bP\u0010QB\u0019\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\bP\u0010RJ\u000f\u0010\u0002\u001a\u00020\u0001H\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u000e\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0011R*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R*\u0010-\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR.\u00103\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010\u000fR$\u0010?\u001a\u0004\u0018\u00010>8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010%\u001a\u0004\bG\u0010'\"\u0004\bH\u0010)R*\u0010J\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020I8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/opensource/svgaplayer/SVGAVideoEntity;", "", "finalize", "()V", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "prepare$library_release", "(Lkotlin/Function0;)V", "prepare", "Lcom/opensource/svgaplayer/proto/MovieEntity;", "obj", "completionBlock", "resetAudios", "(Lcom/opensource/svgaplayer/proto/MovieEntity;Lkotlin/Function0;)V", "resetImages", "(Lcom/opensource/svgaplayer/proto/MovieEntity;)V", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "resetSprites", "", "<set-?>", "FPS", "I", "getFPS", "()I", "setFPS", "(I)V", "", "antiAlias", "Z", "getAntiAlias", "()Z", "setAntiAlias", "(Z)V", "", "Lcom/opensource/svgaplayer/entities/SVGAAudioEntity;", "audios", "Ljava/util/List;", "getAudios$library_release", "()Ljava/util/List;", "setAudios$library_release", "(Ljava/util/List;)V", "Ljava/io/File;", "cacheDir", "Ljava/io/File;", "frames", "getFrames", "setFrames", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "images", "Ljava/util/HashMap;", "getImages$library_release", "()Ljava/util/HashMap;", "setImages$library_release", "(Ljava/util/HashMap;)V", "movieItem", "Lcom/opensource/svgaplayer/proto/MovieEntity;", "getMovieItem", "()Lcom/opensource/svgaplayer/proto/MovieEntity;", "setMovieItem", "Landroid/media/SoundPool;", "soundPool", "Landroid/media/SoundPool;", "getSoundPool$library_release", "()Landroid/media/SoundPool;", "setSoundPool$library_release", "(Landroid/media/SoundPool;)V", "Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteEntity;", "sprites", "getSprites$library_release", "setSprites$library_release", "Lcom/opensource/svgaplayer/utils/SVGARect;", QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, "Lcom/opensource/svgaplayer/utils/SVGARect;", "getVideoSize", "()Lcom/opensource/svgaplayer/utils/SVGARect;", "setVideoSize", "(Lcom/opensource/svgaplayer/utils/SVGARect;)V", "<init>", "(Lorg/json/JSONObject;Ljava/io/File;)V", "(Lcom/opensource/svgaplayer/proto/MovieEntity;Ljava/io/File;)V", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class SVGAVideoEntity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public u9c b;
    public int c;
    public int d;
    public List<q9c> e;
    public List<l9c> f;
    public SoundPool g;
    public HashMap<String, Bitmap> h;
    public File i;
    public MovieEntity j;

    /* loaded from: classes10.dex */
    public static final class a implements SoundPool.OnLoadCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ List b;
        public final /* synthetic */ SVGAVideoEntity c;
        public final /* synthetic */ Function0 d;

        public a(Ref.IntRef intRef, List list, SVGAVideoEntity sVGAVideoEntity, Function0 function0, MovieEntity movieEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intRef, list, sVGAVideoEntity, function0, movieEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intRef;
            this.b = list;
            this.c = sVGAVideoEntity;
            this.d = function0;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, soundPool, i, i2) == null) {
                Ref.IntRef intRef = this.a;
                int i3 = intRef.element + 1;
                intRef.element = i3;
                if (i3 >= this.b.size()) {
                    this.d.invoke();
                }
            }
        }
    }

    public SVGAVideoEntity(MovieEntity movieEntity, File file) {
        float f;
        Float f2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {movieEntity, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        this.b = new u9c(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = 15;
        this.e = CollectionsKt__CollectionsKt.emptyList();
        this.f = CollectionsKt__CollectionsKt.emptyList();
        this.h = new HashMap<>();
        this.j = movieEntity;
        this.i = file;
        MovieParams movieParams = movieEntity.params;
        if (movieParams != null) {
            Float f3 = movieParams.viewBoxWidth;
            if (f3 != null) {
                f = f3.floatValue();
            } else {
                f = 0.0f;
            }
            this.b = new u9c(0.0d, 0.0d, f, movieParams.viewBoxHeight != null ? f2.floatValue() : 0.0f);
            Integer num = movieParams.fps;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 20;
            }
            this.c = i;
            Integer num2 = movieParams.frames;
            if (num2 != null) {
                i2 = num2.intValue();
            } else {
                i2 = 0;
            }
            this.d = i2;
        }
        try {
            k(movieEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m(movieEntity);
    }

    public SVGAVideoEntity(JSONObject jSONObject, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
        this.b = new u9c(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = 15;
        this.e = CollectionsKt__CollectionsKt.emptyList();
        this.f = CollectionsKt__CollectionsKt.emptyList();
        this.h = new HashMap<>();
        this.i = file;
        JSONObject optJSONObject = jSONObject.optJSONObject("movie");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("viewBox");
            if (optJSONObject2 != null) {
                this.b = new u9c(0.0d, 0.0d, optJSONObject2.optDouble("width", 0.0d), optJSONObject2.optDouble("height", 0.0d));
            }
            this.c = optJSONObject.optInt(FpsConstants.REPORT_FPS, 20);
            this.d = optJSONObject.optInt("frames", 0);
        }
        l(jSONObject);
        n(jSONObject);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final List<l9c> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final HashMap<String, Bitmap> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (HashMap) invokeV.objValue;
    }

    public final SoundPool f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (SoundPool) invokeV.objValue;
    }

    public final void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SoundPool soundPool = this.g;
            if (soundPool != null) {
                soundPool.release();
            }
            this.g = null;
            this.h.clear();
        }
    }

    public final List<q9c> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public final u9c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (u9c) invokeV.objValue;
    }

    public final void i(final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, function0) == null) {
            MovieEntity movieEntity = this.j;
            if (movieEntity != null) {
                j(movieEntity, new Function0<Unit>(this, function0) { // from class: com.opensource.svgaplayer.SVGAVideoEntity$prepare$$inlined$let$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Function0 $callback$inlined;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SVGAVideoEntity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, function0};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$callback$inlined = function0;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.$callback$inlined.invoke();
                        }
                    }
                });
            } else {
                function0.invoke();
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.a = z;
        }
    }

    public final void j(MovieEntity movieEntity, Function0<Unit> function0) {
        SoundPool soundPool;
        SoundPool soundPool2;
        HashMap hashMap;
        int i;
        int i2;
        Set<Map.Entry<String, ByteString>> entrySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, movieEntity, function0) == null) {
            List<AudioEntity> list = movieEntity.audios;
            if (list != null) {
                if (!(!list.isEmpty())) {
                    list = null;
                }
                List<AudioEntity> list2 = list;
                if (list2 != null) {
                    Ref.IntRef intRef = new Ref.IntRef();
                    intRef.element = 0;
                    if (Build.VERSION.SDK_INT >= 21) {
                        soundPool = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build()).setMaxStreams(Math.min(12, list2.size())).build();
                    } else {
                        soundPool = new SoundPool(Math.min(12, list2.size()), 3, 0);
                    }
                    HashMap hashMap2 = new HashMap();
                    soundPool.setOnLoadCompleteListener(new a(intRef, list2, this, function0, movieEntity));
                    HashMap hashMap3 = new HashMap();
                    Map<String, ByteString> map = movieEntity.images;
                    if (map != null && (entrySet = map.entrySet()) != null) {
                        Iterator<T> it = entrySet.iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            String imageKey = (String) entry.getKey();
                            byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                            Intrinsics.checkExpressionValueIsNotNull(byteArray, "byteArray");
                            if (byteArray.length >= 4) {
                                List<Byte> slice = ArraysKt___ArraysKt.slice(byteArray, new IntRange(0, 3));
                                if (slice.get(0).byteValue() == 73 && slice.get(1).byteValue() == 68 && slice.get(2).byteValue() == 51 && slice.get(3).byteValue() == 3) {
                                    Intrinsics.checkExpressionValueIsNotNull(imageKey, "imageKey");
                                    hashMap3.put(imageKey, byteArray);
                                }
                            }
                        }
                    }
                    if (hashMap3.size() > 0) {
                        for (Map.Entry entry2 : hashMap3.entrySet()) {
                            File tmpFile = File.createTempFile((String) entry2.getKey(), ".mp3");
                            FileOutputStream fileOutputStream = new FileOutputStream(tmpFile);
                            fileOutputStream.write((byte[]) entry2.getValue());
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            Object key = entry2.getKey();
                            Intrinsics.checkExpressionValueIsNotNull(tmpFile, "tmpFile");
                            hashMap2.put(key, tmpFile);
                        }
                    }
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    for (AudioEntity audio : list2) {
                        Intrinsics.checkExpressionValueIsNotNull(audio, "audio");
                        l9c l9cVar = new l9c(audio);
                        File file = (File) hashMap2.get(audio.audioKey);
                        if (file != null) {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            FileDescriptor fd = fileInputStream.getFD();
                            Integer num = audio.startTime;
                            if (num != null) {
                                i = num.intValue();
                            } else {
                                i = 0;
                            }
                            double d = i;
                            Integer num2 = audio.totalTime;
                            if (num2 != null) {
                                i2 = num2.intValue();
                            } else {
                                i2 = 0;
                            }
                            soundPool2 = soundPool;
                            hashMap = hashMap2;
                            l9cVar.f(Integer.valueOf(soundPool.load(fd, (long) ((d / i2) * fileInputStream.available()), fileInputStream.available(), 1)));
                            fileInputStream.close();
                        } else {
                            soundPool2 = soundPool;
                            hashMap = hashMap2;
                        }
                        arrayList.add(l9cVar);
                        soundPool = soundPool2;
                        hashMap2 = hashMap;
                    }
                    this.f = arrayList;
                    this.g = soundPool;
                    return;
                }
            }
            function0.invoke();
        }
    }

    public final void k(MovieEntity movieEntity) {
        Map<String, ByteString> map;
        Set<Map.Entry<String, ByteString>> entrySet;
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        Bitmap bitmap;
        BitmapFactory.Options options3;
        BitmapFactory.Options options4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, movieEntity) == null) && (map = movieEntity.images) != null && (entrySet = map.entrySet()) != null) {
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String imageKey = (String) entry.getKey();
                options = i9c.a;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                Intrinsics.checkExpressionValueIsNotNull(byteArray, "byteArray");
                if (byteArray.length >= 4) {
                    List<Byte> slice = ArraysKt___ArraysKt.slice(byteArray, new IntRange(0, 3));
                    if (slice.get(0).byteValue() != 73 || slice.get(1).byteValue() != 68 || slice.get(2).byteValue() != 51 || slice.get(3).byteValue() != 3) {
                        int length = byteArray.length;
                        options2 = i9c.a;
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, length, options2);
                        if (decodeByteArray != null) {
                            HashMap<String, Bitmap> hashMap = this.h;
                            Intrinsics.checkExpressionValueIsNotNull(imageKey, "imageKey");
                            hashMap.put(imageKey, decodeByteArray);
                        } else {
                            String utf8 = ((ByteString) entry.getValue()).utf8();
                            if (utf8 != null) {
                                String str = this.i.getAbsolutePath() + "/" + utf8;
                                String str2 = null;
                                if (new File(str).exists()) {
                                    options4 = i9c.a;
                                    bitmap = BitmapFactory.decodeFile(str, options4);
                                } else {
                                    bitmap = null;
                                }
                                if (bitmap != null) {
                                    this.h.put(imageKey, bitmap);
                                } else {
                                    String str3 = this.i.getAbsolutePath() + "/" + imageKey + ".png";
                                    if (new File(str3).exists()) {
                                        str2 = str3;
                                    }
                                    if (str2 != null) {
                                        options3 = i9c.a;
                                        Bitmap decodeFile = BitmapFactory.decodeFile(str2, options3);
                                        if (decodeFile != null) {
                                            this.h.put(imageKey, decodeFile);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        BitmapFactory.Options options;
        Bitmap bitmap;
        BitmapFactory.Options options2;
        BitmapFactory.Options options3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("images")) != null) {
            Iterator<String> keys = optJSONObject.keys();
            Intrinsics.checkExpressionValueIsNotNull(keys, "imgObjects.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                options = i9c.a;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                String str = this.i.getAbsolutePath() + "/" + optJSONObject.get(next);
                String str2 = null;
                if (new File(str).exists()) {
                    options3 = i9c.a;
                    bitmap = BitmapFactory.decodeFile(str, options3);
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    this.h.put(next, bitmap);
                } else {
                    String str3 = this.i.getAbsolutePath() + "/" + next + ".png";
                    if (new File(str3).exists()) {
                        str2 = str3;
                    }
                    if (str2 != null) {
                        options2 = i9c.a;
                        Bitmap decodeFile = BitmapFactory.decodeFile(str2, options2);
                        if (decodeFile != null) {
                            this.h.put(next, decodeFile);
                        }
                    }
                }
            }
        }
    }

    public final void m(MovieEntity movieEntity) {
        List<q9c> emptyList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, movieEntity) == null) {
            List<SpriteEntity> list = movieEntity.sprites;
            if (list != null) {
                emptyList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (SpriteEntity it : list) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    emptyList.add(new q9c(it));
                }
            } else {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            this.e = emptyList;
        }
    }

    public final void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("sprites");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(new q9c(optJSONObject));
                    }
                }
            }
            this.e = CollectionsKt___CollectionsKt.toList(arrayList);
        }
    }
}
