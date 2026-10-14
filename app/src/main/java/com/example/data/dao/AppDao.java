package com.example.data.dao;

import androidx.core.app.NotificationCompat;
import com.example.data.model.AppFileEntity;
import com.example.data.model.BillEntity;
import com.example.data.model.BorrowLendEntity;
import com.example.data.model.ChecklistEntity;
import com.example.data.model.ChecklistItemEntity;
import com.example.data.model.DailyPriceEntity;
import com.example.data.model.ExpenseEntity;
import com.example.data.model.GeneralReminderEntity;
import com.example.data.model.GiftEntity;
import com.example.data.model.HabitEntity;
import com.example.data.model.ImportantDateEntity;
import com.example.data.model.MedicineEntity;
import com.example.data.model.MedicineLogEntity;
import com.example.data.model.NoteEntity;
import com.example.data.model.PrayerStatusEntity;
import com.example.data.model.PrayerTimeSettingEntity;
import com.example.data.model.ShoppingItemEntity;
import com.example.data.model.TaskEntity;
import com.example.data.model.WaterLogEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AppDao.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\bH'J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH§@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\b2\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\bH'J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\tH§@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\b2\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\t0\bH'J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\tH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001fH§@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001fH§@¢\u0006\u0002\u0010#J\u0016\u0010%\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001fH§@¢\u0006\u0002\u0010#J\u000e\u0010&\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\t0\bH'J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\tH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020(H§@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020\u00132\u0006\u0010,\u001a\u00020(H§@¢\u0006\u0002\u0010-J\u0016\u0010/\u001a\u00020\u00132\u0006\u0010,\u001a\u00020(H§@¢\u0006\u0002\u0010-J\u0014\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\t0\bH'J\u001c\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\t0\b2\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u000201H§@¢\u0006\u0002\u00105J\u0016\u00106\u001a\u00020\u00132\u0006\u00104\u001a\u000201H§@¢\u0006\u0002\u00105J\u0016\u00107\u001a\u00020\u00132\u0006\u00104\u001a\u000201H§@¢\u0006\u0002\u00105J&\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000eH§@¢\u0006\u0002\u0010;J\u0018\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\t0\bH'J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020=0\tH§@¢\u0006\u0002\u0010\u000bJ\u001c\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\t0\b2\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020=H§@¢\u0006\u0002\u0010CJ\u0016\u0010D\u001a\u00020\u00132\u0006\u0010B\u001a\u00020=H§@¢\u0006\u0002\u0010CJ\u0016\u0010E\u001a\u00020\u00132\u0006\u0010B\u001a\u00020=H§@¢\u0006\u0002\u0010CJ\u0014\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\t0\bH'J\u0018\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0\b2\u0006\u0010\r\u001a\u00020\u000eH'J\u0018\u0010I\u001a\u0004\u0018\u00010G2\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010JJ\u0016\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020GH§@¢\u0006\u0002\u0010MJ\u0018\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\t0\bH'J\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0\tH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020OH§@¢\u0006\u0002\u0010TJ\u0016\u0010U\u001a\u00020\u00132\u0006\u0010S\u001a\u00020OH§@¢\u0006\u0002\u0010TJ\u0016\u0010V\u001a\u00020\u00132\u0006\u0010S\u001a\u00020OH§@¢\u0006\u0002\u0010TJ\u0014\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0\t0\bH'J\u0016\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020XH§@¢\u0006\u0002\u0010[J\u0016\u0010\\\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020XH§@¢\u0006\u0002\u0010[J\u0016\u0010]\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020XH§@¢\u0006\u0002\u0010[J\u0018\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0\t0\bH'J\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020_0\tH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010b\u001a\u00020\u00052\u0006\u0010c\u001a\u00020_H§@¢\u0006\u0002\u0010dJ\u0016\u0010e\u001a\u00020\u00132\u0006\u0010c\u001a\u00020_H§@¢\u0006\u0002\u0010dJ\u0016\u0010f\u001a\u00020\u00132\u0006\u0010c\u001a\u00020_H§@¢\u0006\u0002\u0010dJ\u0014\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0\t0\bH'J\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020h0\tH§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010j\u001a\u0004\u0018\u00010h2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010k\u001a\u00020\u00052\u0006\u0010l\u001a\u00020hH§@¢\u0006\u0002\u0010mJ\u0016\u0010n\u001a\u00020\u00132\u0006\u0010l\u001a\u00020hH§@¢\u0006\u0002\u0010mJ\u0016\u0010o\u001a\u00020\u00132\u0006\u0010l\u001a\u00020hH§@¢\u0006\u0002\u0010mJ\u0016\u0010p\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0\t0\bH'J\u0014\u0010s\u001a\b\u0012\u0004\u0012\u00020r0\tH§@¢\u0006\u0002\u0010\u000bJ\u001c\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0\t0\b2\u0006\u0010\r\u001a\u00020\u000eH'J\u001c\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0\t0\b2\u0006\u0010v\u001a\u00020\u000eH'J\u0016\u0010w\u001a\u00020\u00052\u0006\u0010x\u001a\u00020rH§@¢\u0006\u0002\u0010yJ\u0016\u0010z\u001a\u00020\u00132\u0006\u0010x\u001a\u00020rH§@¢\u0006\u0002\u0010yJ\u0016\u0010{\u001a\u00020\u00132\u0006\u0010x\u001a\u00020rH§@¢\u0006\u0002\u0010yJ\u0016\u0010|\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020~0\t0\bH'J\u0018\u0010\u007f\u001a\u0004\u0018\u00010~2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0080\u0001\u001a\u00020\u00052\u0007\u0010\u0081\u0001\u001a\u00020~H§@¢\u0006\u0003\u0010\u0082\u0001J\u0019\u0010\u0083\u0001\u001a\u00020\u00132\u0007\u0010\u0081\u0001\u001a\u00020~H§@¢\u0006\u0003\u0010\u0082\u0001J\u0019\u0010\u0084\u0001\u001a\u00020\u00132\u0007\u0010\u0081\u0001\u001a\u00020~H§@¢\u0006\u0003\u0010\u0082\u0001J\u001a\u0010\u0085\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0086\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH'J\u001a\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010JJ\u0016\u0010\u0088\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0086\u00010\t0\bH'J\u001f\u0010\u0089\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0086\u00010\t0\b2\u0007\u0010\u008a\u0001\u001a\u00020\u000eH'J\u001a\u0010\u008b\u0001\u001a\u00020\u00132\b\u0010\u008c\u0001\u001a\u00030\u0086\u0001H§@¢\u0006\u0003\u0010\u008d\u0001J\u0017\u0010\u008e\u0001\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010JJ\u0016\u0010\u008f\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0090\u00010\t0\bH'J\u0016\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010\tH§@¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u0092\u0001\u001a\u00020\u00132\b\u0010\u0093\u0001\u001a\u00030\u0090\u0001H§@¢\u0006\u0003\u0010\u0094\u0001J \u0010\u0095\u0001\u001a\u00020\u00132\u000e\u0010\u0096\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010\tH§@¢\u0006\u0003\u0010\u0097\u0001J\u001a\u0010\u0098\u0001\u001a\u00020\u00132\b\u0010\u0093\u0001\u001a\u00030\u0090\u0001H§@¢\u0006\u0003\u0010\u0094\u0001J\u0019\u0010\u0099\u0001\u001a\u0004\u0018\u00010X2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0015\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020X0\tH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u009b\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009c\u00010\t0\bH'J\u0016\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u009c\u00010\tH§@¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001a\u0010\u009f\u0001\u001a\u00020\u00052\b\u0010 \u0001\u001a\u00030\u009c\u0001H§@¢\u0006\u0003\u0010¡\u0001J\u001a\u0010¢\u0001\u001a\u00020\u00132\b\u0010 \u0001\u001a\u00030\u009c\u0001H§@¢\u0006\u0003\u0010¡\u0001J\u001a\u0010£\u0001\u001a\u00020\u00132\b\u0010 \u0001\u001a\u00030\u009c\u0001H§@¢\u0006\u0003\u0010¡\u0001J\u0017\u0010¤\u0001\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010¥\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¦\u00010\t0\bH'J\u0016\u0010§\u0001\u001a\t\u0012\u0005\u0012\u00030¦\u00010\tH§@¢\u0006\u0002\u0010\u000bJ\u001f\u0010¨\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¦\u00010\t0\b2\u0007\u0010©\u0001\u001a\u00020\u000eH'J\u001a\u0010ª\u0001\u001a\u0005\u0018\u00010¦\u00012\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001a\u0010«\u0001\u001a\u00020\u00052\b\u0010¬\u0001\u001a\u00030¦\u0001H§@¢\u0006\u0003\u0010\u00ad\u0001J\u001a\u0010®\u0001\u001a\u00020\u00132\b\u0010¬\u0001\u001a\u00030¦\u0001H§@¢\u0006\u0003\u0010\u00ad\u0001J\u001a\u0010¯\u0001\u001a\u00020\u00132\b\u0010¬\u0001\u001a\u00030¦\u0001H§@¢\u0006\u0003\u0010\u00ad\u0001J\u0017\u0010°\u0001\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010±\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030²\u00010\t0\bH'J\u0016\u0010³\u0001\u001a\t\u0012\u0005\u0012\u00030²\u00010\tH§@¢\u0006\u0002\u0010\u000bJ\u001a\u0010´\u0001\u001a\u0005\u0018\u00010²\u00012\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001a\u0010µ\u0001\u001a\u00020\u00052\b\u0010¶\u0001\u001a\u00030²\u0001H§@¢\u0006\u0003\u0010·\u0001J\u001a\u0010¸\u0001\u001a\u00020\u00132\b\u0010¶\u0001\u001a\u00030²\u0001H§@¢\u0006\u0003\u0010·\u0001J\u001a\u0010¹\u0001\u001a\u00020\u00132\b\u0010¶\u0001\u001a\u00030²\u0001H§@¢\u0006\u0003\u0010·\u0001J\u0017\u0010º\u0001\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010»\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00010\t0\bH'J\u0016\u0010½\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010\tH§@¢\u0006\u0002\u0010\u000bJ\u001f\u0010¾\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00010\t0\b2\u0007\u0010¿\u0001\u001a\u00020\u0005H'J\u001f\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010\t2\u0007\u0010¿\u0001\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0019\u0010Á\u0001\u001a\u00020\u00052\u0007\u0010\"\u001a\u00030¼\u0001H§@¢\u0006\u0003\u0010Â\u0001J \u0010Ã\u0001\u001a\u00020\u00132\u000e\u0010Ä\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010\tH§@¢\u0006\u0003\u0010\u0097\u0001J\u0019\u0010Å\u0001\u001a\u00020\u00132\u0007\u0010\"\u001a\u00030¼\u0001H§@¢\u0006\u0003\u0010Â\u0001J\u0019\u0010Æ\u0001\u001a\u00020\u00132\u0007\u0010\"\u001a\u00030¼\u0001H§@¢\u0006\u0003\u0010Â\u0001J\u0018\u0010Ç\u0001\u001a\u00020\u00132\u0007\u0010¿\u0001\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006È\u0001À\u0006\u0003"}, d2 = {"Lcom/example/data/dao/AppDao;", "", "getTaskById", "Lcom/example/data/model/TaskEntity;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTasks", "Lkotlinx/coroutines/flow/Flow;", "", "getAllTasksDirect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTasksForDate", "dateStr", "", "insertTask", "task", "(Lcom/example/data/model/TaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "", "deleteTask", "getAllExpenses", "Lcom/example/data/model/ExpenseEntity;", "getAllExpensesDirect", "getExpensesForDate", "insertExpense", "expense", "(Lcom/example/data/model/ExpenseEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExpense", "deleteExpense", "getAllShoppingItems", "Lcom/example/data/model/ShoppingItemEntity;", "getAllShoppingItemsDirect", "insertShoppingItem", "item", "(Lcom/example/data/model/ShoppingItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateShoppingItem", "deleteShoppingItem", "clearPurchasedShoppingItems", "getMedicineById", "Lcom/example/data/model/MedicineEntity;", "getAllMedicines", "getAllMedicinesDirect", "insertMedicine", "medicine", "(Lcom/example/data/model/MedicineEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMedicine", "deleteMedicine", "getAllMedicineLogs", "Lcom/example/data/model/MedicineLogEntity;", "getMedicineLogsForDate", "insertMedicineLog", "log", "(Lcom/example/data/model/MedicineLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMedicineLog", "deleteMedicineLog", "deleteMedicineLogForDose", "medicineId", "timeStr", "(JLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGeneralReminderById", "Lcom/example/data/model/GeneralReminderEntity;", "getAllGeneralReminders", "getAllGeneralRemindersDirect", "getGeneralRemindersForDate", "insertGeneralReminder", NotificationCompat.CATEGORY_REMINDER, "(Lcom/example/data/model/GeneralReminderEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGeneralReminder", "deleteGeneralReminder", "getAllWaterLogs", "Lcom/example/data/model/WaterLogEntity;", "getWaterLog", "getWaterLogDirect", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWaterLog", "waterLog", "(Lcom/example/data/model/WaterLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBorrowLendById", "Lcom/example/data/model/BorrowLendEntity;", "getAllBorrowLend", "getAllBorrowLendDirect", "insertBorrowLend", "record", "(Lcom/example/data/model/BorrowLendEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBorrowLend", "deleteBorrowLend", "getAllNotes", "Lcom/example/data/model/NoteEntity;", "insertNote", "note", "(Lcom/example/data/model/NoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNote", "deleteNote", "getBillById", "Lcom/example/data/model/BillEntity;", "getAllBills", "getAllBillsDirect", "insertBill", "bill", "(Lcom/example/data/model/BillEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBill", "deleteBill", "getAllImportantDates", "Lcom/example/data/model/ImportantDateEntity;", "getAllImportantDatesDirect", "getImportantDateById", "insertImportantDate", "date", "(Lcom/example/data/model/ImportantDateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateImportantDate", "deleteImportantDate", "deleteImportantDateById", "getAllDailyPrices", "Lcom/example/data/model/DailyPriceEntity;", "getAllDailyPricesDirect", "getDailyPricesForDate", "getDailyPricesForItem", "itemName", "insertDailyPrice", "price", "(Lcom/example/data/model/DailyPriceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDailyPrice", "deleteDailyPrice", "deleteDailyPriceById", "getAllHabits", "Lcom/example/data/model/HabitEntity;", "getHabitById", "insertHabit", "habit", "(Lcom/example/data/model/HabitEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHabit", "deleteHabit", "getPrayerStatus", "Lcom/example/data/model/PrayerStatusEntity;", "getPrayerStatusDirect", "getAllPrayerStatuses", "getPrayerStatusesByPrefix", "prefix", "insertPrayerStatus", NotificationCompat.CATEGORY_STATUS, "(Lcom/example/data/model/PrayerStatusEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePrayerStatusForDate", "getAllPrayerTimeSettings", "Lcom/example/data/model/PrayerTimeSettingEntity;", "getAllPrayerTimeSettingsDirect", "insertPrayerTimeSetting", "setting", "(Lcom/example/data/model/PrayerTimeSettingEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPrayerTimeSettings", "settings", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePrayerTimeSetting", "getNoteById", "getAllNotesDirect", "getAllGifts", "Lcom/example/data/model/GiftEntity;", "getAllGiftsDirect", "getGiftById", "insertGift", "gift", "(Lcom/example/data/model/GiftEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGift", "deleteGift", "deleteGiftById", "getAllFiles", "Lcom/example/data/model/AppFileEntity;", "getAllFilesDirect", "getFilesByCategory", "category", "getFileById", "insertFile", "file", "(Lcom/example/data/model/AppFileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFile", "deleteFile", "deleteFileById", "getAllChecklists", "Lcom/example/data/model/ChecklistEntity;", "getAllChecklistsDirect", "getChecklistById", "insertChecklist", "checklist", "(Lcom/example/data/model/ChecklistEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChecklist", "deleteChecklist", "deleteChecklistById", "getAllChecklistItems", "Lcom/example/data/model/ChecklistItemEntity;", "getAllChecklistItemsDirect", "getItemsForChecklist", "checklistId", "getItemsForChecklistDirect", "insertChecklistItem", "(Lcom/example/data/model/ChecklistItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChecklistItems", "items", "updateChecklistItem", "deleteChecklistItem", "deleteItemsForChecklist", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AppDao {
    Object clearPurchasedShoppingItems(Continuation<? super Unit> continuation);

    Object deleteBill(BillEntity billEntity, Continuation<? super Unit> continuation);

    Object deleteBorrowLend(BorrowLendEntity borrowLendEntity, Continuation<? super Unit> continuation);

    Object deleteChecklist(ChecklistEntity checklistEntity, Continuation<? super Unit> continuation);

    Object deleteChecklistById(long j, Continuation<? super Unit> continuation);

    Object deleteChecklistItem(ChecklistItemEntity checklistItemEntity, Continuation<? super Unit> continuation);

    Object deleteDailyPrice(DailyPriceEntity dailyPriceEntity, Continuation<? super Unit> continuation);

    Object deleteDailyPriceById(long j, Continuation<? super Unit> continuation);

    Object deleteExpense(ExpenseEntity expenseEntity, Continuation<? super Unit> continuation);

    Object deleteFile(AppFileEntity appFileEntity, Continuation<? super Unit> continuation);

    Object deleteFileById(long j, Continuation<? super Unit> continuation);

    Object deleteGeneralReminder(GeneralReminderEntity generalReminderEntity, Continuation<? super Unit> continuation);

    Object deleteGift(GiftEntity giftEntity, Continuation<? super Unit> continuation);

    Object deleteGiftById(long j, Continuation<? super Unit> continuation);

    Object deleteHabit(HabitEntity habitEntity, Continuation<? super Unit> continuation);

    Object deleteImportantDate(ImportantDateEntity importantDateEntity, Continuation<? super Unit> continuation);

    Object deleteImportantDateById(long j, Continuation<? super Unit> continuation);

    Object deleteItemsForChecklist(long j, Continuation<? super Unit> continuation);

    Object deleteMedicine(MedicineEntity medicineEntity, Continuation<? super Unit> continuation);

    Object deleteMedicineLog(MedicineLogEntity medicineLogEntity, Continuation<? super Unit> continuation);

    Object deleteMedicineLogForDose(long j, String str, String str2, Continuation<? super Unit> continuation);

    Object deleteNote(NoteEntity noteEntity, Continuation<? super Unit> continuation);

    Object deletePrayerStatusForDate(String str, Continuation<? super Unit> continuation);

    Object deletePrayerTimeSetting(PrayerTimeSettingEntity prayerTimeSettingEntity, Continuation<? super Unit> continuation);

    Object deleteShoppingItem(ShoppingItemEntity shoppingItemEntity, Continuation<? super Unit> continuation);

    Object deleteTask(TaskEntity taskEntity, Continuation<? super Unit> continuation);

    Flow<List<BillEntity>> getAllBills();

    Object getAllBillsDirect(Continuation<? super List<BillEntity>> continuation);

    Flow<List<BorrowLendEntity>> getAllBorrowLend();

    Object getAllBorrowLendDirect(Continuation<? super List<BorrowLendEntity>> continuation);

    Flow<List<ChecklistItemEntity>> getAllChecklistItems();

    Object getAllChecklistItemsDirect(Continuation<? super List<ChecklistItemEntity>> continuation);

    Flow<List<ChecklistEntity>> getAllChecklists();

    Object getAllChecklistsDirect(Continuation<? super List<ChecklistEntity>> continuation);

    Flow<List<DailyPriceEntity>> getAllDailyPrices();

    Object getAllDailyPricesDirect(Continuation<? super List<DailyPriceEntity>> continuation);

    Flow<List<ExpenseEntity>> getAllExpenses();

    Object getAllExpensesDirect(Continuation<? super List<ExpenseEntity>> continuation);

    Flow<List<AppFileEntity>> getAllFiles();

    Object getAllFilesDirect(Continuation<? super List<AppFileEntity>> continuation);

    Flow<List<GeneralReminderEntity>> getAllGeneralReminders();

    Object getAllGeneralRemindersDirect(Continuation<? super List<GeneralReminderEntity>> continuation);

    Flow<List<GiftEntity>> getAllGifts();

    Object getAllGiftsDirect(Continuation<? super List<GiftEntity>> continuation);

    Flow<List<HabitEntity>> getAllHabits();

    Flow<List<ImportantDateEntity>> getAllImportantDates();

    Object getAllImportantDatesDirect(Continuation<? super List<ImportantDateEntity>> continuation);

    Flow<List<MedicineLogEntity>> getAllMedicineLogs();

    Flow<List<MedicineEntity>> getAllMedicines();

    Object getAllMedicinesDirect(Continuation<? super List<MedicineEntity>> continuation);

    Flow<List<NoteEntity>> getAllNotes();

    Object getAllNotesDirect(Continuation<? super List<NoteEntity>> continuation);

    Flow<List<PrayerStatusEntity>> getAllPrayerStatuses();

    Flow<List<PrayerTimeSettingEntity>> getAllPrayerTimeSettings();

    Object getAllPrayerTimeSettingsDirect(Continuation<? super List<PrayerTimeSettingEntity>> continuation);

    Flow<List<ShoppingItemEntity>> getAllShoppingItems();

    Object getAllShoppingItemsDirect(Continuation<? super List<ShoppingItemEntity>> continuation);

    Flow<List<TaskEntity>> getAllTasks();

    Object getAllTasksDirect(Continuation<? super List<TaskEntity>> continuation);

    Flow<List<WaterLogEntity>> getAllWaterLogs();

    Object getBillById(long j, Continuation<? super BillEntity> continuation);

    Object getBorrowLendById(long j, Continuation<? super BorrowLendEntity> continuation);

    Object getChecklistById(long j, Continuation<? super ChecklistEntity> continuation);

    Flow<List<DailyPriceEntity>> getDailyPricesForDate(String dateStr);

    Flow<List<DailyPriceEntity>> getDailyPricesForItem(String itemName);

    Flow<List<ExpenseEntity>> getExpensesForDate(String dateStr);

    Object getFileById(long j, Continuation<? super AppFileEntity> continuation);

    Flow<List<AppFileEntity>> getFilesByCategory(String category);

    Object getGeneralReminderById(long j, Continuation<? super GeneralReminderEntity> continuation);

    Flow<List<GeneralReminderEntity>> getGeneralRemindersForDate(String dateStr);

    Object getGiftById(long j, Continuation<? super GiftEntity> continuation);

    Object getHabitById(long j, Continuation<? super HabitEntity> continuation);

    Object getImportantDateById(long j, Continuation<? super ImportantDateEntity> continuation);

    Flow<List<ChecklistItemEntity>> getItemsForChecklist(long checklistId);

    Object getItemsForChecklistDirect(long j, Continuation<? super List<ChecklistItemEntity>> continuation);

    Object getMedicineById(long j, Continuation<? super MedicineEntity> continuation);

    Flow<List<MedicineLogEntity>> getMedicineLogsForDate(String dateStr);

    Object getNoteById(long j, Continuation<? super NoteEntity> continuation);

    Flow<PrayerStatusEntity> getPrayerStatus(String dateStr);

    Object getPrayerStatusDirect(String str, Continuation<? super PrayerStatusEntity> continuation);

    Flow<List<PrayerStatusEntity>> getPrayerStatusesByPrefix(String prefix);

    Object getTaskById(long j, Continuation<? super TaskEntity> continuation);

    Flow<List<TaskEntity>> getTasksForDate(String dateStr);

    Flow<WaterLogEntity> getWaterLog(String dateStr);

    Object getWaterLogDirect(String str, Continuation<? super WaterLogEntity> continuation);

    Object insertBill(BillEntity billEntity, Continuation<? super Long> continuation);

    Object insertBorrowLend(BorrowLendEntity borrowLendEntity, Continuation<? super Long> continuation);

    Object insertChecklist(ChecklistEntity checklistEntity, Continuation<? super Long> continuation);

    Object insertChecklistItem(ChecklistItemEntity checklistItemEntity, Continuation<? super Long> continuation);

    Object insertChecklistItems(List<ChecklistItemEntity> list, Continuation<? super Unit> continuation);

    Object insertDailyPrice(DailyPriceEntity dailyPriceEntity, Continuation<? super Long> continuation);

    Object insertExpense(ExpenseEntity expenseEntity, Continuation<? super Long> continuation);

    Object insertFile(AppFileEntity appFileEntity, Continuation<? super Long> continuation);

    Object insertGeneralReminder(GeneralReminderEntity generalReminderEntity, Continuation<? super Long> continuation);

    Object insertGift(GiftEntity giftEntity, Continuation<? super Long> continuation);

    Object insertHabit(HabitEntity habitEntity, Continuation<? super Long> continuation);

    Object insertImportantDate(ImportantDateEntity importantDateEntity, Continuation<? super Long> continuation);

    Object insertMedicine(MedicineEntity medicineEntity, Continuation<? super Long> continuation);

    Object insertMedicineLog(MedicineLogEntity medicineLogEntity, Continuation<? super Long> continuation);

    Object insertNote(NoteEntity noteEntity, Continuation<? super Long> continuation);

    Object insertPrayerStatus(PrayerStatusEntity prayerStatusEntity, Continuation<? super Unit> continuation);

    Object insertPrayerTimeSetting(PrayerTimeSettingEntity prayerTimeSettingEntity, Continuation<? super Unit> continuation);

    Object insertPrayerTimeSettings(List<PrayerTimeSettingEntity> list, Continuation<? super Unit> continuation);

    Object insertShoppingItem(ShoppingItemEntity shoppingItemEntity, Continuation<? super Long> continuation);

    Object insertTask(TaskEntity taskEntity, Continuation<? super Long> continuation);

    Object insertWaterLog(WaterLogEntity waterLogEntity, Continuation<? super Unit> continuation);

    Object updateBill(BillEntity billEntity, Continuation<? super Unit> continuation);

    Object updateBorrowLend(BorrowLendEntity borrowLendEntity, Continuation<? super Unit> continuation);

    Object updateChecklist(ChecklistEntity checklistEntity, Continuation<? super Unit> continuation);

    Object updateChecklistItem(ChecklistItemEntity checklistItemEntity, Continuation<? super Unit> continuation);

    Object updateDailyPrice(DailyPriceEntity dailyPriceEntity, Continuation<? super Unit> continuation);

    Object updateExpense(ExpenseEntity expenseEntity, Continuation<? super Unit> continuation);

    Object updateFile(AppFileEntity appFileEntity, Continuation<? super Unit> continuation);

    Object updateGeneralReminder(GeneralReminderEntity generalReminderEntity, Continuation<? super Unit> continuation);

    Object updateGift(GiftEntity giftEntity, Continuation<? super Unit> continuation);

    Object updateHabit(HabitEntity habitEntity, Continuation<? super Unit> continuation);

    Object updateImportantDate(ImportantDateEntity importantDateEntity, Continuation<? super Unit> continuation);

    Object updateMedicine(MedicineEntity medicineEntity, Continuation<? super Unit> continuation);

    Object updateMedicineLog(MedicineLogEntity medicineLogEntity, Continuation<? super Unit> continuation);

    Object updateNote(NoteEntity noteEntity, Continuation<? super Unit> continuation);

    Object updateShoppingItem(ShoppingItemEntity shoppingItemEntity, Continuation<? super Unit> continuation);

    Object updateTask(TaskEntity taskEntity, Continuation<? super Unit> continuation);
}
