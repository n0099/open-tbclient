package d.a.n0.l0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.widget.EditText;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.s.c.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final KeyEvent f60844a = new KeyEvent(0, 67);

    /* loaded from: classes4.dex */
    public static class a extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f60845a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f60846b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f60847c;

        public a(EditText editText, Context context, v vVar) {
            this.f60845a = editText;
            this.f60846b = context;
            this.f60847c = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (aVar != null) {
                int selectionStart = this.f60845a.getSelectionStart();
                b.e(this.f60846b, this.f60845a, new SpannableStringBuilder(this.f60847c.c()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f60847c.f());
            }
        }
    }

    /* renamed from: d.a.n0.l0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1484b extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f60848a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f60849b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60850c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f60851d;

        public C1484b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            this.f60848a = editText;
            this.f60849b = context;
            this.f60850c = spannableStringBuilder;
            this.f60851d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((C1484b) aVar, str, i2);
            if (aVar != null) {
                int selectionStart = this.f60848a.getSelectionStart();
                b.e(this.f60849b, this.f60848a, this.f60850c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f60851d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60852a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60853b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60854c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f60855d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f60856e;

        public c(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f60852a = spannableStringBuilder;
            this.f60853b = i2;
            this.f60854c = i3;
            this.f60855d = iArr;
            this.f60856e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            f fVar;
            f fVar2;
            super.onLoaded((c) aVar, str, i2);
            if (aVar != null) {
                Bitmap p = aVar.p();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                int width = (int) (p.getWidth() * (d.a.m0.b.d.G() ? 0.4d : 0.5d));
                bitmapDrawable.setBounds(0, 0, width, width);
                bitmapDrawable.setGravity(119);
                this.f60852a.setSpan(new d.a.c.k.b(bitmapDrawable, 1), this.f60853b, this.f60854c, 33);
                int[] iArr = this.f60855d;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f60856e) == null) {
                    return;
                }
                fVar2.a(this.f60852a);
                return;
            }
            this.f60852a.setSpan("", this.f60853b, this.f60854c, 33);
            int[] iArr2 = this.f60855d;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f60856e) == null) {
                return;
            }
            fVar.a(this.f60852a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f60857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60859c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f60860d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f60861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f60862f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f60857a = context;
            this.f60858b = spannableStringBuilder;
            this.f60859c = i2;
            this.f60860d = i3;
            this.f60861e = iArr;
            this.f60862f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            f fVar;
            Bitmap p;
            f fVar2;
            super.onLoaded((d) aVar, str, i2);
            if (aVar != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                int dimensionPixelSize = this.f60857a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f60857a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f60858b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f60859c, this.f60860d, 33);
                int[] iArr = this.f60861e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f60862f) == null) {
                    return;
                }
                fVar2.a(this.f60858b);
                return;
            }
            this.f60858b.setSpan("", this.f60859c, this.f60860d, 33);
            int[] iArr2 = this.f60861e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f60862f) == null) {
                return;
            }
            fVar.a(this.f60858b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f60863a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60864b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60865c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f60866d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f60867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f60868f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f60863a = context;
            this.f60864b = spannableStringBuilder;
            this.f60865c = i2;
            this.f60866d = i3;
            this.f60867e = iArr;
            this.f60868f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            f fVar;
            Bitmap p;
            f fVar2;
            super.onLoaded((e) aVar, str, i2);
            if (aVar != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                int dimensionPixelSize = this.f60863a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f60863a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f60864b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f60865c, this.f60866d, 33);
                int[] iArr = this.f60867e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f60868f) == null) {
                    return;
                }
                fVar2.a(this.f60864b);
                return;
            }
            this.f60864b.setSpan("", this.f60865c, this.f60866d, 33);
            int[] iArr2 = this.f60867e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f60868f) == null) {
                return;
            }
            fVar.a(this.f60864b);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(SpannableStringBuilder spannableStringBuilder);
    }

    public static void a(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart() - 1;
        if (selectionStart > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
            editText.onKeyDown(67, f60844a);
        }
        editText.onKeyDown(67, f60844a);
        int selectionStart2 = editText.getSelectionStart();
        if (text != null) {
            editText.setSelection(selectionStart2);
        }
    }

    public static void b(Context context, v vVar, EditText editText) {
        if (vVar == null || editText == null || vVar.c() == null) {
            return;
        }
        String c2 = vVar.c();
        EmotionGroupType f2 = vVar.f();
        if (f2 != EmotionGroupType.LOCAL && f2 != EmotionGroupType.USER_COLLECT && !c2.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            editText.getText().insert(editText.getSelectionStart(), c2);
        } else if (c2 != null) {
            d.a.c.e.l.d.h().k(c2, 20, new C1484b(editText, context, new SpannableStringBuilder(c2), f2), 0, 0, BdUniqueId.gen(), null, c2, Boolean.FALSE, null);
        }
    }

    public static void c(Context context, v vVar, EditText editText) {
        if (vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g()) || editText == null) {
            return;
        }
        editText.getText().toString();
        d.a.c.e.l.d.h().k(vVar.g(), 10, new a(editText, context, vVar), 0, 0, BdUniqueId.gen(), new Object[0]);
    }

    public static void d(Context context, String str, f fVar) {
        String str2;
        CustomResponsedMessage runTask;
        if (context == null || TextUtils.isEmpty(str) || fVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int[] iArr = {d.a.n0.l0.a.a(str)};
        if (iArr[0] <= 0) {
            if (fVar != null) {
                fVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = d.a.n0.l0.a.f60842a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                d.a.c.e.l.d.h().k(group, 20, new c(spannableStringBuilder, start, end, iArr, fVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
        while (true) {
            str2 = ",";
            if (!matcher2.find()) {
                break;
            }
            String group2 = matcher2.group();
            String[] split = group2.split(",");
            if (split != null && split.length == 5) {
                d.a.c.e.l.d.h().k(group2, 20, new d(context, spannableStringBuilder, matcher2.start(), matcher2.end(), iArr, fVar), 0, 0, BdUniqueId.gen(), null, group2, Boolean.FALSE, null);
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(str2);
            if (split2 != null && split2.length == 6) {
                String str3 = str2;
                e eVar = new e(context, spannableStringBuilder, matcher3.start(), matcher3.end(), iArr, fVar);
                if (!TextUtils.isEmpty(split2[1])) {
                    d.a.c.e.l.d.h().k(Uri.decode(split2[1].replace("net_", "")), 10, eVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                }
                str2 = str3;
            }
        }
    }

    public static void e(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, d.a.c.k.d.a aVar, EmotionGroupType emotionGroupType) {
        if (context == null || editText == null || TextUtils.isEmpty(spannableStringBuilder) || aVar == null) {
            return;
        }
        Bitmap p = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        int width = p.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i3 = d.a.m0.b.d.G() ? (int) (width * 0.4d) : (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i3, i3);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds80);
            int width2 = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
            if (width2 > editText.getMeasuredWidth()) {
                width2 = (int) (p.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new d.a.n0.l0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i2, spannableStringBuilder);
    }
}
