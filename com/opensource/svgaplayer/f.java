package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.TbConfig;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
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
import kotlin.collections.n;
import kotlin.h;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.p;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes18.dex */
public final class f {
    private List<com.opensource.svgaplayer.entities.a> audios;
    private File cacheDir;
    private boolean pzg;
    private com.opensource.svgaplayer.b.c pzh;
    private int pzi;
    private int pzj;
    private SoundPool pzk;
    private HashMap<String, Bitmap> pzl;
    private MovieEntity pzm;
    private List<com.opensource.svgaplayer.entities.f> sprites;

    protected final void finalize() {
        SoundPool soundPool = this.pzk;
        if (soundPool != null) {
            soundPool.release();
        }
        this.pzk = null;
        this.pzl.clear();
    }

    public final boolean ezP() {
        return this.pzg;
    }

    public final void setAntiAlias(boolean z) {
        this.pzg = z;
    }

    public final com.opensource.svgaplayer.b.c ezQ() {
        return this.pzh;
    }

    public final int getFPS() {
        return this.pzi;
    }

    public final int ezR() {
        return this.pzj;
    }

    public final List<com.opensource.svgaplayer.entities.f> ezS() {
        return this.sprites;
    }

    public final List<com.opensource.svgaplayer.entities.a> ezT() {
        return this.audios;
    }

    public final SoundPool ezU() {
        return this.pzk;
    }

    public final HashMap<String, Bitmap> ezV() {
        return this.pzl;
    }

    public f(JSONObject jSONObject, File file) {
        p.o(jSONObject, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        p.o(file, "cacheDir");
        this.pzg = true;
        this.pzh = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.pzi = 15;
        this.sprites = n.eDK();
        this.audios = n.eDK();
        this.pzl = new HashMap<>();
        this.cacheDir = file;
        JSONObject optJSONObject = jSONObject.optJSONObject("movie");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("viewBox");
            if (optJSONObject2 != null) {
                this.pzh = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, optJSONObject2.optDouble("width", 0.0d), optJSONObject2.optDouble("height", 0.0d));
            }
            this.pzi = optJSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS, 20);
            this.pzj = optJSONObject.optInt("frames", 0);
        }
        eC(jSONObject);
        eD(jSONObject);
    }

    public f(MovieEntity movieEntity, File file) {
        Float f;
        p.o(movieEntity, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        p.o(file, "cacheDir");
        this.pzg = true;
        this.pzh = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.pzi = 15;
        this.sprites = n.eDK();
        this.audios = n.eDK();
        this.pzl = new HashMap<>();
        this.pzm = movieEntity;
        this.cacheDir = file;
        MovieParams movieParams = movieEntity.params;
        if (movieParams != null) {
            Float f2 = movieParams.viewBoxWidth;
            this.pzh = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, f2 != null ? f2.floatValue() : 0.0f, movieParams.viewBoxHeight != null ? f.floatValue() : 0.0f);
            Integer num = movieParams.fps;
            this.pzi = num != null ? num.intValue() : 20;
            Integer num2 = movieParams.frames;
            this.pzj = num2 != null ? num2.intValue() : 0;
        }
        try {
            a(movieEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        b(movieEntity);
    }

    public final void a(kotlin.jvm.a.a<h> aVar) {
        p.o(aVar, BuyTBeanActivityConfig.CALLBACK);
        MovieEntity movieEntity = this.pzm;
        if (movieEntity != null) {
            a(movieEntity, new SVGAVideoEntity$prepare$$inlined$let$lambda$1(this, aVar));
        } else {
            aVar.invoke();
        }
    }

    private final void eC(JSONObject jSONObject) {
        BitmapFactory.Options options;
        Bitmap bitmap;
        BitmapFactory.Options options2;
        BitmapFactory.Options options3;
        JSONObject optJSONObject = jSONObject.optJSONObject(TbConfig.IMAGE_CACHE_DIR_NAME);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            p.n(keys, "imgObjects.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                options = g.pzr;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                String str = this.cacheDir.getAbsolutePath() + "/" + optJSONObject.get(next);
                if (new File(str).exists()) {
                    options3 = g.pzr;
                    bitmap = BitmapFactory.decodeFile(str, options3);
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    this.pzl.put(next, bitmap);
                } else {
                    String str2 = this.cacheDir.getAbsolutePath() + "/" + next + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX;
                    if (!new File(str2).exists()) {
                        str2 = null;
                    }
                    if (str2 != null) {
                        options2 = g.pzr;
                        Bitmap decodeFile = BitmapFactory.decodeFile(str2, options2);
                        if (decodeFile != null) {
                            this.pzl.put(next, decodeFile);
                        }
                    }
                }
            }
        }
    }

    private final void a(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        Bitmap bitmap;
        BitmapFactory.Options options3;
        BitmapFactory.Options options4;
        Map<String, ByteString> map = movieEntity.images;
        if (map == null || (entrySet = map.entrySet()) == null) {
            return;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            options = g.pzr;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
            p.n(byteArray, "byteArray");
            if (byteArray.length >= 4) {
                List<Byte> a2 = kotlin.collections.f.a(byteArray, new kotlin.b.h(0, 3));
                if (a2.get(0).byteValue() != 73 || a2.get(1).byteValue() != 68 || a2.get(2).byteValue() != 51 || a2.get(3).byteValue() != 3) {
                    int length = byteArray.length;
                    options2 = g.pzr;
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, length, options2);
                    if (decodeByteArray != null) {
                        p.n(str, "imageKey");
                        this.pzl.put(str, decodeByteArray);
                    } else {
                        String utf8 = ((ByteString) entry.getValue()).utf8();
                        if (utf8 != null) {
                            String str2 = this.cacheDir.getAbsolutePath() + "/" + utf8;
                            if (new File(str2).exists()) {
                                options4 = g.pzr;
                                bitmap = BitmapFactory.decodeFile(str2, options4);
                            } else {
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                this.pzl.put(str, bitmap);
                            } else {
                                String str3 = this.cacheDir.getAbsolutePath() + "/" + str + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX;
                                if (!new File(str3).exists()) {
                                    str3 = null;
                                }
                                if (str3 != null) {
                                    options3 = g.pzr;
                                    Bitmap decodeFile = BitmapFactory.decodeFile(str3, options3);
                                    if (decodeFile != null) {
                                        this.pzl.put(str, decodeFile);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final void eD(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sprites");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new com.opensource.svgaplayer.entities.f(optJSONObject));
                }
            }
        }
        this.sprites = n.g(arrayList);
    }

    private final void b(MovieEntity movieEntity) {
        ArrayList eDK;
        List<SpriteEntity> list = movieEntity.sprites;
        if (list == null) {
            eDK = n.eDK();
        } else {
            List<SpriteEntity> list2 = list;
            ArrayList arrayList = new ArrayList(n.a(list2, 10));
            for (SpriteEntity spriteEntity : list2) {
                p.n(spriteEntity, AdvanceSetting.NETWORK_TYPE);
                arrayList.add(new com.opensource.svgaplayer.entities.f(spriteEntity));
            }
            eDK = arrayList;
        }
        this.sprites = eDK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4] */
    private final void a(MovieEntity movieEntity, kotlin.jvm.a.a<h> aVar) {
        Integer num;
        Set<Map.Entry<String, ByteString>> entrySet;
        List<AudioEntity> list = movieEntity.audios;
        if (list != null) {
            List<AudioEntity> list2 = !list.isEmpty() ? list : null;
            if (list2 != null) {
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = 0;
                SoundPool build = Build.VERSION.SDK_INT >= 21 ? new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build()).setMaxStreams(Math.min(12, list2.size())).build() : new SoundPool(Math.min(12, list2.size()), 3, 0);
                HashMap hashMap = new HashMap();
                build.setOnLoadCompleteListener(new a(intRef, list2, this, aVar, movieEntity));
                HashMap hashMap2 = new HashMap();
                Map<String, ByteString> map = movieEntity.images;
                if (map != null && (entrySet = map.entrySet()) != null) {
                    Iterator<T> it = entrySet.iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        String str = (String) entry.getKey();
                        byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                        p.n(byteArray, "byteArray");
                        if (byteArray.length >= 4) {
                            List<Byte> a2 = kotlin.collections.f.a(byteArray, new kotlin.b.h(0, 3));
                            if (a2.get(0).byteValue() == 73 && a2.get(1).byteValue() == 68 && a2.get(2).byteValue() == 51 && a2.get(3).byteValue() == 3) {
                                p.n(str, "imageKey");
                                hashMap2.put(str, byteArray);
                            }
                        }
                    }
                }
                if (hashMap2.size() > 0) {
                    for (Map.Entry entry2 : hashMap2.entrySet()) {
                        File createTempFile = File.createTempFile((String) entry2.getKey(), ".mp3");
                        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                        fileOutputStream.write((byte[]) entry2.getValue());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Object key = entry2.getKey();
                        p.n(createTempFile, "tmpFile");
                        hashMap.put(key, createTempFile);
                    }
                }
                List<AudioEntity> list3 = list2;
                ArrayList arrayList = new ArrayList(n.a(list3, 10));
                for (AudioEntity audioEntity : list3) {
                    p.n(audioEntity, "audio");
                    com.opensource.svgaplayer.entities.a aVar2 = new com.opensource.svgaplayer.entities.a(audioEntity);
                    File file = (File) hashMap.get(audioEntity.audioKey);
                    if (file != null) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        FileDescriptor fd = fileInputStream.getFD();
                        Integer num2 = audioEntity.startTime;
                        aVar2.t(Integer.valueOf(build.load(fd, (long) (((num2 != null ? num2.intValue() : 0) / (audioEntity.totalTime != null ? num.intValue() : 0)) * fileInputStream.available()), fileInputStream.available(), 1)));
                        fileInputStream.close();
                    }
                    arrayList.add(aVar2);
                }
                this.audios = arrayList;
                this.pzk = build;
                return;
            }
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class a implements SoundPool.OnLoadCompleteListener {
        final /* synthetic */ Ref.IntRef pzn;
        final /* synthetic */ List pzo;
        final /* synthetic */ kotlin.jvm.a.a pzp;
        final /* synthetic */ MovieEntity pzq;
        final /* synthetic */ f this$0;

        a(Ref.IntRef intRef, List list, f fVar, kotlin.jvm.a.a aVar, MovieEntity movieEntity) {
            this.pzn = intRef;
            this.pzo = list;
            this.this$0 = fVar;
            this.pzp = aVar;
            this.pzq = movieEntity;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
            this.pzn.element++;
            if (this.pzn.element >= this.pzo.size()) {
                this.pzp.invoke();
            }
        }
    }
}
