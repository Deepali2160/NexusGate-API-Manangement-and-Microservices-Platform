package in.nexusgate.Api_Management_Service.service;


import in.nexusgate.Api_Management_Service.dto.responseDto.HealthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthService {

    public final JdbcTemplate jdbcTemplate;

    public String getHealth()
    {
        String databaseStatus = "DOWN";
        try
        {
            Integer result =  jdbcTemplate.queryForObject("SELECT 1",Integer.class);

            if(Integer.valueOf(1).equals(result))
            {
                databaseStatus = "UP";
            }
        }
        catch (Exception e)
        {
            System.out.println("MY SQL HEALTH CHECK FAILED " + e.getMessage());
        }
        return databaseStatus;
    }
}
