package d.a.o0.l0;

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
import d.a.n0.s.c.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final KeyEvent f60969a = new KeyEvent(0, 67);

    /* loaded from: classes4.dex */
    public static class a extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f60970a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f60971b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f60972c;

        public a(EditText editText, Context context, v vVar) {
            this.f60970a = editText;
            this.f60971b = context;
            this.f60972c = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (aVar != null) {
                int selectionStart = this.f60970a.getSelectionStart();
                b.e(this.f60971b, this.f60970a, new SpannableStringBuilder(this.f60972c.c()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f60972c.f());
            }
        }
    }

    /* renamed from: d.a.o0.l0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1488b extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f60973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f60974b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60975c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f60976d;

        public C1488b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            this.f60973a = editText;
            this.f60974b = context;
            this.f60975c = spannableStringBuilder;
            this.f60976d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((C1488b) aVar, str, i2);
            if (aVar != null) {
                int selectionStart = this.f60973a.getSelectionStart();
                b.e(this.f60974b, this.f60973a, this.f60975c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f60976d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60977a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60978b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60979c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f60980d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f60981e;

        public c(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f60977a = spannableStringBuilder;
            this.f60978b = i2;
            this.f60979c = i3;
            this.f60980d = iArr;
            this.f60981e = fVar;
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
                int width = (int) (p.getWidth() * (d.a.n0.b.d.G() ? 0.4d : 0.5d));
                bitmapDrawable.setBounds(0, 0, width, width);
                bitmapDrawable.setGravity(119);
                this.f60977a.setSpan(new d.a.c.k.b(bitmapDrawable, 1), this.f60978b, this.f60979c, 33);
                int[] iArr = this.f60980d;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f60981e) == null) {
                    return;
                }
                fVar2.a(this.f60977a);
                return;
            }
            this.f60977a.setSpan("", this.f60978b, this.f60979c, 33);
            int[] iArr2 = this.f60980d;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f60981e) == null) {
                return;
            }
            fVar.a(this.f60977a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f60982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60983b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60984c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f60985d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f60986e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f60987f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f60982a = context;
            this.f60983b = spannableStringBuilder;
            this.f60984c = i2;
            this.f60985d = i3;
            this.f60986e = iArr;
            this.f60987f = fVar;
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
                int dimensionPixelSize = this.f60982a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f60982a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f60983b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f60984c, this.f60985d, 33);
                int[] iArr = this.f60986e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f60987f) == null) {
                    return;
                }
                fVar2.a(this.f60983b);
                return;
            }
            this.f60983b.setSpan("", this.f60984c, this.f60985d, 33);
            int[] iArr2 = this.f60986e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f60987f) == null) {
                return;
            }
            fVar.a(this.f60983b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f60988a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60989b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60990c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f60991d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f60992e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f60993f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f60988a = context;
            this.f60989b = spannableStringBuilder;
            this.f60990c = i2;
            this.f60991d = i3;
            this.f60992e = iArr;
            this.f60993f = fVar;
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
                int dimensionPixelSize = this.f60988a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f60988a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f60989b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f60990c, this.f60991d, 33);
                int[] iArr = this.f60992e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f60993f) == null) {
                    return;
                }
                fVar2.a(this.f60989b);
                return;
            }
            this.f60989b.setSpan("", this.f60990c, this.f60991d, 33);
            int[] iArr2 = this.f60992e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f60993f) == null) {
                return;
            }
            fVar.a(this.f60989b);
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
            editText.onKeyDown(67, f60969a);
        }
        editText.onKeyDown(67, f60969a);
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
            d.a.c.e.l.d.h().k(c2, 20, new C1488b(editText, context, new SpannableStringBuilder(c2), f2), 0, 0, BdUniqueId.gen(), null, c2, Boolean.FALSE, null);
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
        int[] iArr = {d.a.o0.l0.a.a(str)};
        if (iArr[0] <= 0) {
            if (fVar != null) {
                fVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = d.a.o0.l0.a.f60967a.matcher(spannableStringBuilder);
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
            int i3 = d.a.n0.b.d.G() ? (int) (width * 0.4d) : (int) (width * 0.5d);
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
        spannableStringBuilder.setSpan(new d.a.o0.l0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i2, spannableStringBuilder);
    }
}
