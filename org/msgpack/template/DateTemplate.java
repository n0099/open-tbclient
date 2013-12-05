package org.msgpack.template;

import java.util.Date;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class DateTemplate extends AbstractTemplate<Date> {

    /* renamed from: a  reason: collision with root package name */
    static final DateTemplate f3074a = new DateTemplate();

    private DateTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Date date, boolean z) {
        if (date == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(date.getTime());
    }

    public static DateTemplate a() {
        return f3074a;
    }
}
