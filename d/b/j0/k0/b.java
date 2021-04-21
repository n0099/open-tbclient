package d.b.j0.k0;

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
import d.b.c.e.p.l;
import d.b.i0.s.c.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final KeyEvent f58264a = new KeyEvent(0, 67);

    /* loaded from: classes4.dex */
    public static class a extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f58265a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f58266b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f58267c;

        public a(EditText editText, Context context, v vVar) {
            this.f58265a = editText;
            this.f58266b = context;
            this.f58267c = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                int selectionStart = this.f58265a.getSelectionStart();
                b.e(this.f58266b, this.f58265a, new SpannableStringBuilder(this.f58267c.b()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f58267c.e());
            }
        }
    }

    /* renamed from: d.b.j0.k0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1399b extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f58268a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f58269b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f58270c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f58271d;

        public C1399b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            this.f58268a = editText;
            this.f58269b = context;
            this.f58270c = spannableStringBuilder;
            this.f58271d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((C1399b) aVar, str, i);
            if (aVar != null) {
                int selectionStart = this.f58268a.getSelectionStart();
                b.e(this.f58269b, this.f58268a, this.f58270c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f58271d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f58272a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f58273b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f58274c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f58275d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f58276e;

        public c(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f58272a = spannableStringBuilder;
            this.f58273b = i;
            this.f58274c = i2;
            this.f58275d = iArr;
            this.f58276e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            f fVar;
            f fVar2;
            super.onLoaded((c) aVar, str, i);
            if (aVar != null) {
                Bitmap p = aVar.p();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                int width = (int) (p.getWidth() * 0.5d);
                bitmapDrawable.setBounds(0, 0, width, width);
                bitmapDrawable.setGravity(119);
                this.f58272a.setSpan(new d.b.c.j.b(bitmapDrawable, 1), this.f58273b, this.f58274c, 33);
                int[] iArr = this.f58275d;
                int i2 = iArr[0] - 1;
                iArr[0] = i2;
                if (i2 != 0 || (fVar2 = this.f58276e) == null) {
                    return;
                }
                fVar2.a(this.f58272a);
                return;
            }
            this.f58272a.setSpan("", this.f58273b, this.f58274c, 33);
            int[] iArr2 = this.f58275d;
            int i3 = iArr2[0] - 1;
            iArr2[0] = i3;
            if (i3 != 0 || (fVar = this.f58276e) == null) {
                return;
            }
            fVar.a(this.f58272a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f58277a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f58278b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f58279c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f58280d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f58281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f58282f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f58277a = context;
            this.f58278b = spannableStringBuilder;
            this.f58279c = i;
            this.f58280d = i2;
            this.f58281e = iArr;
            this.f58282f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            f fVar;
            Bitmap p;
            f fVar2;
            super.onLoaded((d) aVar, str, i);
            if (aVar != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                int dimensionPixelSize = this.f58277a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f58277a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f58278b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f58279c, this.f58280d, 33);
                int[] iArr = this.f58281e;
                int i2 = iArr[0] - 1;
                iArr[0] = i2;
                if (i2 != 0 || (fVar2 = this.f58282f) == null) {
                    return;
                }
                fVar2.a(this.f58278b);
                return;
            }
            this.f58278b.setSpan("", this.f58279c, this.f58280d, 33);
            int[] iArr2 = this.f58281e;
            int i3 = iArr2[0] - 1;
            iArr2[0] = i3;
            if (i3 != 0 || (fVar = this.f58282f) == null) {
                return;
            }
            fVar.a(this.f58278b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f58283a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f58284b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f58285c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f58286d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f58287e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f58288f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f58283a = context;
            this.f58284b = spannableStringBuilder;
            this.f58285c = i;
            this.f58286d = i2;
            this.f58287e = iArr;
            this.f58288f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            f fVar;
            Bitmap p;
            f fVar2;
            super.onLoaded((e) aVar, str, i);
            if (aVar != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                int dimensionPixelSize = this.f58283a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f58283a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f58284b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f58285c, this.f58286d, 33);
                int[] iArr = this.f58287e;
                int i2 = iArr[0] - 1;
                iArr[0] = i2;
                if (i2 != 0 || (fVar2 = this.f58288f) == null) {
                    return;
                }
                fVar2.a(this.f58284b);
                return;
            }
            this.f58284b.setSpan("", this.f58285c, this.f58286d, 33);
            int[] iArr2 = this.f58287e;
            int i3 = iArr2[0] - 1;
            iArr2[0] = i3;
            if (i3 != 0 || (fVar = this.f58288f) == null) {
                return;
            }
            fVar.a(this.f58284b);
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
            editText.onKeyDown(67, f58264a);
        }
        editText.onKeyDown(67, f58264a);
        int selectionStart2 = editText.getSelectionStart();
        if (text != null) {
            editText.setSelection(selectionStart2);
        }
    }

    public static void b(Context context, v vVar, EditText editText) {
        if (vVar == null || editText == null || vVar.b() == null) {
            return;
        }
        String b2 = vVar.b();
        EmotionGroupType e2 = vVar.e();
        if (e2 != EmotionGroupType.LOCAL && e2 != EmotionGroupType.USER_COLLECT && !b2.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            editText.getText().insert(editText.getSelectionStart(), b2);
        } else if (b2 != null) {
            d.b.c.e.l.d.h().k(b2, 20, new C1399b(editText, context, new SpannableStringBuilder(b2), e2), 0, 0, BdUniqueId.gen(), null, b2, Boolean.FALSE, null);
        }
    }

    public static void c(Context context, v vVar, EditText editText) {
        if (vVar == null || TextUtils.isEmpty(vVar.b()) || TextUtils.isEmpty(vVar.f()) || editText == null) {
            return;
        }
        editText.getText().toString();
        d.b.c.e.l.d.h().k(vVar.f(), 10, new a(editText, context, vVar), 0, 0, BdUniqueId.gen(), new Object[0]);
    }

    public static void d(Context context, String str, f fVar) {
        String str2;
        CustomResponsedMessage runTask;
        if (context == null || TextUtils.isEmpty(str) || fVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int[] iArr = {d.b.j0.k0.a.a(str)};
        if (iArr[0] <= 0) {
            if (fVar != null) {
                fVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = d.b.j0.k0.a.f58262a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                d.b.c.e.l.d.h().k(group, 20, new c(spannableStringBuilder, start, end, iArr, fVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
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
                d.b.c.e.l.d.h().k(group2, 20, new d(context, spannableStringBuilder, matcher2.start(), matcher2.end(), iArr, fVar), 0, 0, BdUniqueId.gen(), null, group2, Boolean.FALSE, null);
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(str2);
            if (split2 != null && split2.length == 6) {
                String str3 = str2;
                e eVar = new e(context, spannableStringBuilder, matcher3.start(), matcher3.end(), iArr, fVar);
                if (!TextUtils.isEmpty(split2[1])) {
                    d.b.c.e.l.d.h().k(Uri.decode(split2[1].replace("net_", "")), 10, eVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                }
                str2 = str3;
            }
        }
    }

    public static void e(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i, d.b.c.j.d.a aVar, EmotionGroupType emotionGroupType) {
        if (context == null || editText == null || TextUtils.isEmpty(spannableStringBuilder) || aVar == null) {
            return;
        }
        Bitmap p = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        int width = p.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i2 = (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i2, i2);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds80);
            int width2 = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
            if (width2 > editText.getMeasuredWidth()) {
                width2 = (int) (p.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new d.b.j0.k0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i, spannableStringBuilder);
    }
}
