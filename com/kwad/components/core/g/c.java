package com.kwad.components.core.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.core.g.a;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class c implements ImageLoadingListener {
    @Nullable
    public a LA;
    public long LD;
    public b Lz;
    public long hj;
    public int LB = 1;
    public int LC = 16;
    public List<h> LE = new CopyOnWriteArrayList();

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view2) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view2) {
    }

    /* renamed from: com.kwad.components.core.g.c$6  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c() {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.LA = aVar;
        aVar.a(new a.InterfaceC0645a() { // from class: com.kwad.components.core.g.c.1
            public boolean LF = false;
            public boolean LG = false;

            private void kU() {
                if (this.LF) {
                    return;
                }
                c.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.1.2
                    public static void e(h hVar) {
                        hVar.onMediaPlayCompleted();
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        e(hVar);
                    }
                });
                this.LF = true;
            }

            private void ot() {
                if (!this.LG) {
                    com.kwad.sdk.core.e.c.d("KSImagePlayer", "onFirstFrame: ");
                    this.LG = true;
                    c.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.1.3
                        public static void e(h hVar) {
                            hVar.onMediaPlayStart();
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.kwad.sdk.g.a
                        public final /* synthetic */ void accept(h hVar) {
                            e(hVar);
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0645a
            public final void x(final long j) {
                com.kwad.sdk.core.e.c.d("KSImagePlayer", "onTimerProgress: " + j);
                if (j == 0) {
                    ot();
                }
                c.this.hj = j;
                c.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* renamed from: e */
                    public void accept(h hVar) {
                        hVar.onMediaPlayProgress(c.this.LD, j);
                    }
                });
                if (c.this.hj >= c.this.LD && c.this.LD > 0) {
                    kU();
                }
            }
        });
    }

    private void os() {
        b bVar = this.Lz;
        if (bVar != null) {
            bVar.setImageGravity(this.LB | this.LC);
        }
    }

    public final void destroy() {
        this.LE.clear();
        b bVar = this.Lz;
        if (bVar != null && bVar.getParent() != null) {
            ((ViewGroup) this.Lz.getParent()).removeView(this.Lz);
        }
        this.Lz = null;
        a aVar = this.LA;
        if (aVar != null) {
            aVar.destroy();
            this.LA = null;
        }
    }

    public final long getPlayDuration() {
        return this.hj;
    }

    public final void pause() {
        a aVar = this.LA;
        if (aVar != null) {
            aVar.pause();
        }
        b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.2
            public static void e(h hVar) {
                hVar.onMediaPlayPaused();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        });
    }

    public final void play() {
        a aVar = this.LA;
        if (aVar != null) {
            aVar.start();
        }
    }

    public final void resume() {
        a aVar = this.LA;
        if (aVar != null) {
            aVar.resume();
            b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.3
                public static void e(h hVar) {
                    hVar.onMediaPlaying();
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.kwad.sdk.g.a
                public final /* synthetic */ void accept(h hVar) {
                    e(hVar);
                }
            });
        }
    }

    public final void skipToEnd() {
        b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.4
            public static void e(h hVar) {
                hVar.onMediaPlayCompleted();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        });
    }

    public final void stop() {
        a aVar = this.LA;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public static /* synthetic */ int a(c cVar, FailReason.FailType failType) {
        return a(failType);
    }

    public static int a(FailReason.FailType failType) {
        int i = AnonymousClass6.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return -1;
                    }
                    return -5;
                }
                return -4;
            }
            return -3;
        }
        return -2;
    }

    public final void c(h hVar) {
        if (hVar != null) {
            this.LE.add(hVar);
        }
    }

    public final void d(h hVar) {
        if (hVar != null) {
            this.LE.remove(hVar);
        }
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.Lz == null) {
            this.Lz = new b(context);
        }
        return this.Lz;
    }

    public final void setHorizontalGravity(int i) {
        this.LC = com.kwad.components.core.b.c.aj(i);
        os();
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.Lz;
        if (bVar != null) {
            bVar.setImageScaleType(scaleType);
        }
    }

    public final void setURLs(List<String> list) {
        if (list != null && list.size() != 0) {
            String str = list.get(0);
            b bVar = this.Lz;
            if (bVar != null) {
                bVar.a(str, this);
            }
        }
    }

    public final void setVerticalGravity(int i) {
        this.LC = com.kwad.components.core.b.c.ai(i);
        os();
    }

    public final void y(long j) {
        this.LD = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void b(com.kwad.sdk.g.a<h> aVar) {
        List<h> list;
        if (aVar != null && (list = this.LE) != null) {
            for (h hVar : list) {
                aVar.accept(hVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view2, final FailReason failReason) {
        b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: e */
            public void accept(h hVar) {
                hVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
            }
        });
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        b bVar = this.Lz;
        if (bVar != null) {
            bVar.setRadius(f, f2, f3, f4);
        }
    }
}
