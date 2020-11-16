package kotlin.text;
@kotlin.h
/* loaded from: classes9.dex */
public enum RegexOption implements e {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);
    
    private final int mask;
    private final int value;

    RegexOption(int i, int i2) {
        this.value = i;
        this.mask = i2;
    }

    /* synthetic */ RegexOption(int i, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(i, (i3 & 2) != 0 ? i : i2);
    }

    @Override // kotlin.text.e
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.e
    public int getValue() {
        return this.value;
    }
}
