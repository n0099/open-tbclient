package com.kwad.sdk.emotion.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class EmojiTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    e f6459a;
    private a b;
    private boolean c;
    private boolean d;
    private boolean e;

    /* loaded from: classes3.dex */
    public interface a {
        void a(EmojiTextView emojiTextView, boolean z);
    }

    public EmojiTextView(Context context) {
        super(context);
        this.c = false;
        this.d = false;
        this.e = false;
        a();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.d = false;
        this.e = false;
        a();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.d = false;
        this.e = false;
        a();
    }

    private void a() {
        this.f6459a = new d(this);
        addTextChangedListener(new TextWatcher() { // from class: com.kwad.sdk.emotion.widget.EmojiTextView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (EmojiTextView.this.f6459a == null) {
                    return;
                }
                if (!EmojiTextView.this.c) {
                    EmojiTextView.this.f6459a.a(EmojiTextView.this.getEditableText());
                } else if (!EmojiTextView.this.e && !TextUtils.isEmpty(EmojiTextView.this.getEditableText())) {
                    EmojiTextView.this.e = true;
                    EmojiTextView.this.f6459a.a(EmojiTextView.this.getEditableText());
                } else if (EmojiTextView.this.d) {
                } else {
                    EmojiTextView.this.f6459a.a(EmojiTextView.this.getEditableText());
                    if (EmojiTextView.this.c) {
                        EmojiTextView.this.d = true;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (getText() == null || getText().length() <= 0) {
            return;
        }
        this.f6459a.a(getEditableText());
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i, int i2) {
        try {
            super.append(charSequence, i, i2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    public e getKSTextDisplayHandler() {
        return this.f6459a;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        CharSequence text = super.getText();
        return text == null ? "" : text;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException e) {
            setText(getText().toString());
            try {
                super.onMeasure(i, i2);
            } catch (IndexOutOfBoundsException e2) {
                setText("");
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        try {
            return super.performLongClick();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        this.d = true;
        super.postInvalidate();
    }

    public void setKSTextDisplayHandler(e eVar) {
        this.f6459a = eVar;
    }

    public void setOnPressedListener(a aVar) {
        this.b = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        a aVar;
        boolean isPressed = isPressed();
        super.setPressed(z);
        if (!(isPressed ^ z) || (aVar = this.b) == null) {
            return;
        }
        aVar.a(this, z);
    }

    public void setPreventDeadCycleInvalidate(boolean z) {
        this.c = z;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }
}
