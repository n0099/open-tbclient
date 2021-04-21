package com.kwad.sdk.emotion.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.kwad.sdk.emotion.model.CDNUrl;
import com.kwad.sdk.emotion.model.EmotionInfo;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.q;
import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public volatile Queue<com.kwai.filedownloader.a> f35060a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public volatile Queue<com.kwai.filedownloader.a> f35061b = new ConcurrentLinkedQueue();

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(String str);
    }

    @Nullable
    public static Bitmap a(String str, boolean z) {
        if (b.a().b(str, z)) {
            return BitmapFactory.decodeFile(b.a().a(str, z));
        }
        return null;
    }

    private String a(String str, String str2) {
        String str3;
        if (str2 != null) {
            String substring = str2.substring(str2.lastIndexOf("/") + 1);
            str3 = substring.substring(substring.lastIndexOf("."));
        } else {
            str3 = EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
        }
        return str + str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (d.class) {
            if (this.f35060a.isEmpty() && this.f35061b.isEmpty()) {
                return;
            }
            int size = 10 - this.f35061b.size();
            int size2 = this.f35060a.size();
            for (int i = 0; i < size && i < size2; i++) {
                com.kwai.filedownloader.a poll = this.f35060a.poll();
                if (poll != null && !poll.c()) {
                    this.f35061b.offer(poll);
                    poll.e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final String[] strArr, final String str, final boolean z, final a aVar) {
        if (i >= strArr.length) {
            aVar.a();
            return;
        }
        final b a2 = b.a();
        final String a3 = a(str, strArr[i]);
        com.kwai.filedownloader.a a4 = q.a().a(strArr[i]);
        StringBuilder sb = new StringBuilder();
        sb.append(z ? a2.c() : a2.b());
        sb.append(File.separator);
        sb.append(a3);
        this.f35060a.offer(a4.a(sb.toString()).b(false).a((i) new c() { // from class: com.kwad.sdk.emotion.b.d.1
            @Override // com.kwad.sdk.emotion.b.c, com.kwai.filedownloader.i
            public void a(com.kwai.filedownloader.a aVar2, Throwable th) {
                d.this.f35061b.remove(aVar2);
                d.this.a(i + 1, strArr, str, z, aVar);
                d.this.a();
            }

            @Override // com.kwai.filedownloader.i
            public void c(com.kwai.filedownloader.a aVar2) {
                d.this.f35061b.remove(aVar2);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(aVar2.o());
                }
                a2.a(str, a3, z);
                d.this.a();
            }
        }));
    }

    private void a(List<CDNUrl> list, String str, boolean z, a aVar) {
        String a2 = b.a().a(str, z);
        if (a2 != null) {
            if (aVar != null) {
                aVar.a(a2);
            }
        } else if (list == null || list.isEmpty()) {
        } else {
            a(0, com.kwad.sdk.emotion.b.a.a(list, null), str, z, aVar);
        }
    }

    public void a(EmotionInfo emotionInfo, boolean z, a aVar) {
        a(z ? emotionInfo.emotionImageBigUrl : emotionInfo.emotionImageSmallUrl, emotionInfo.id, z, aVar);
        a();
    }
}
